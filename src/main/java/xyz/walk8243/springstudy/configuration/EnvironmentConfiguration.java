package xyz.walk8243.springstudy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import xyz.walk8243.springstudy.configuration.annotation.IsNotLocalProfileCondition;
import xyz.walk8243.springstudy.model.constant.Environment;

public interface EnvironmentConfiguration {
	public Environment env();

	@Profile({"production", "prod"})
	@Configuration
	@Conditional(IsNotLocalProfileCondition.class)
	public static class ProductionEnvironment implements EnvironmentConfiguration {

		@Bean
		public Environment env() {
			return Environment.PRODUCTION;
		}
	}

	@Profile({"staging", "stg"})
	@Configuration
	@Conditional(IsNotLocalProfileCondition.class)
	public static class StagingEnvironment implements EnvironmentConfiguration {

		@Bean
		public Environment env() {
			return Environment.STAGING;
		}
	}

	@Profile({"development", "dev"})
	@Configuration
	@Conditional(IsNotLocalProfileCondition.class)
	public static class DevelopmentEnvironment implements EnvironmentConfiguration {

		@Bean
		public Environment env() {
			return Environment.DEVELOPMENT;
		}
	}

	@Profile({"sandbox"})
	@Configuration
	@Conditional(IsNotLocalProfileCondition.class)
	public static class SandboxEnvironment implements EnvironmentConfiguration {

		@Bean
		public Environment env() {
			return Environment.SANDBOX;
		}
	}

	@Profile({"default", "local"})
	@Configuration
	public static class LocalEnvironment implements EnvironmentConfiguration {

		@Bean
		public Environment env() {
			return Environment.LOCAL;
		}
	}
}
