package com.example.demo1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ConfigProps props;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.props);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@ConfigurationProperties(prefix = "demo")
	@EnableConfigurationProperties
	public static class ConfigProps {

		private Map<String, String> mymap;

		public Map<String, String> getMymap() {
			return mymap;
		}

		public void setMymap(Map<String, String> mymap) {
			this.mymap = mymap;
		}

		@Override
		public String toString() {
			return "ConfigProps [mymap=" + mymap + "]";
		}
	}
}
