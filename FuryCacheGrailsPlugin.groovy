import net.spy.memcached.spring.MemcachedClientFactoryBean
import com.fury.api.FuryUtils

class FuryCacheGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Your name"
    def authorEmail = ""
    def title = "Plugin summary/headline"
    def description = '''\\
Brief description of the plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/fury-cache"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    String resolveCacheBeanName(String key){
        String ret = key - "CACHE_"

        ret = ret - "_CONFIG_ENDPOINT"

        ret = ret.toLowerCase().replaceAll(/_([a-z])/,{ all, cap ->
            return cap.toUpperCase()
        })

        return "${ret}Cache"
    }

    def doWithSpring = {

        FuryUtils.environmentVariablesDesencrypted().each{key,cfgEndPoint ->
            if(key.startsWith("CACHE_")){
                String cacheBeanName = resolveCacheBeanName(key)

                println "Configurando ${cacheBeanName}"
                "${cacheBeanName}"(MemcachedClientFactoryBean) { bean ->
                    servers = cfgEndPoint
                    opTimeout = 30
                }
            }
        }        

    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
