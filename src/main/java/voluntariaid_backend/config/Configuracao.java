package voluntariaid_backend.config;

import org.springframework.boot.task.SimpleAsyncTaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class Configuracao {

  @Bean
  public SimpleAsyncTaskSchedulerBuilder simpleAsyncTaskSchedulerBuilder() {
    return new SimpleAsyncTaskSchedulerBuilder()
      .virtualThreads(true);
  }
}
