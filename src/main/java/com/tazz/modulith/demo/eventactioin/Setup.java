package com.tazz.modulith.demo.eventactioin;

import com.tazz.modulith.demo.eventactioin.action.Action;
import com.tazz.modulith.demo.eventactioin.action.CustomEventMarker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Setup implements ApplicationRunner {

    private final EventActionRepository actionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);

        provider.addIncludeFilter(new AnnotationTypeFilter(CustomEventMarker.class));

        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents("com.tazz.modulith.demo");

        Map<String, String> eventActionMap = new HashMap<>();

        beanDefinitions.forEach(bd -> {
            if (bd instanceof AnnotatedBeanDefinition) {
                Map<String, Object> annotatedMap = ((AnnotatedBeanDefinition) bd).getMetadata()
                        .getAnnotationAttributes(CustomEventMarker.class.getCanonicalName());

                eventActionMap.put(annotatedMap.get("eventAction").toString(), bd.getBeanClassName());
            }
        });

        var eventActionList = new ArrayList<EventAction>();

        eventActionMap.forEach((k, v) -> {
            EventAction eventAction = new EventAction();
            Action action = Action.valueOf(k);
            eventAction.setAction(action);
            eventAction.setEventCanonicalName(v);

            if (actionRepository.findByAction(action).isEmpty()) {
                eventActionList.add(eventAction);
            }
        });

        if (!eventActionList.isEmpty()) {
            actionRepository.saveAll(eventActionList);
        }
    }
}
