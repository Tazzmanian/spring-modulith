@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {
                "inventry::exposed", "eventaction::action"
        }
)
package com.tazz.modulith.demo.order;