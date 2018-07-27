package greenbookapi


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class NegroGreenPopApplication {
    static void main(String[] args) {
        SpringApplication.run NegroGreenPopApplication.class, args
    }

    //TODO: Enable JVM Metrics
    //https://devcenter.heroku.com/articles/language-runtime-metrics#setup-instructions
    //https://devcenter.heroku.com/articles/language-runtime-metrics-jvm

    //TODO: Configure secrets
    //https://devcenter.heroku.com/articles/config-vars
}
