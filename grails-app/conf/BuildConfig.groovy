grails.project.work.dir = 'target'

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits 'global'
  log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

  repositories {
	  mavenCentral()
    grailsCentral()
  }

  dependencies {
	    compile "org.springframework:spring-orm:$springVersion"

		compile ('org.activiti:activiti-engine:5.15.1') {
			excludes 'livetribe-jsr223', 'spring-beans'
		}

		runtime ('org.activiti:activiti-spring:5.15.1') {
			excludes 'spring-context', 'spring-jdbc', 'spring-orm', 'slf4j-log4j12', 'commons-dbcp'
		}

		//runtime 'org.springframework:spring-asm:3.1.4.RELEASE'
		runtime 'javax.mail:mail:1.4.1'
		test ('org.subethamail:subethasmtp-smtp:1.2') {
			excludes 'commons-logging'
		}
		test ('org.subethamail:subethasmtp-wiser:1.2') {
			excludes 'commons-logging'
		}
  }

	plugins {
		build ":release:3.0.1"
		build ":tomcat:7.0.53"

		compile ':scaffolding:2.1.0', ':cache:1.1.6', ':asset-pipeline:1.8.7', ':hibernate:3.6.10.15' {
			export = false
		}
	}
}
