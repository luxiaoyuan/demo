//package com.example.demo.mqtt;
//
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.endpoint.MessageProducerSupport;
//import org.springframework.integration.handler.LoggingHandler;
//import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
//import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
//import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
//import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
//import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//
//
//@Configuration
//public class MqttConfiguration {
//	
//	/**
//	 * client Factory
//	 * @return
//	 */
//	@Bean
//	public MqttPahoClientFactory mqttPahoClientFactory() 
//	{
//		DefaultMqttPahoClientFactory factory=new DefaultMqttPahoClientFactory();
////		factory.setServerURIs("tcp://demo:1883");
////		factory.setUserName("");
////		factory.setPassword("");
//		MqttConnectOptions options = new MqttConnectOptions();
//        options.setServerURIs(new String[] { "tcp://host1:1883", "tcp://host2:1883" });
//        options.setUserName("username");
//        options.setPassword("password".toCharArray());
//        factory.setConnectionOptions(options);
//		return factory;
//	}
//	
//	/**
//	 * consumer
//	 */
//	@Bean
//	public IntegrationFlow mqttInFlow() 
//	{
////		return IntegrationFlows.from(mqttInbound())
////				.transform(p->p+",received from MQTT")
////				.handle(logger())
////				.get();
//		return IntegrationFlows.from(outChannel())
//				.handle(mqttOutbound())
//				.get();
//	}
//	
//	private LoggingHandler logger() 
//	{
//		LoggingHandler loggingHandler=new LoggingHandler("INFO");
//		loggingHandler.setLoggerName("siSample");
//		return loggingHandler;
//	}
//	
//	@Bean
//	public MessageProducerSupport mqttInbound() 
//	{
//		MqttPahoMessageDrivenChannelAdapter adapter=
//				new MqttPahoMessageDrivenChannelAdapter
//				("siSampleConsumer", mqttPahoClientFactory(), "siSampleTopic");
//	    adapter.setCompletionTimeout(5000);
//		adapter.setConverter(new DefaultPahoMessageConverter());
//		adapter.setQos(1);
//		return adapter;
//	
//	}
//	
//	
//	/**
//	 * 配置producer
//	 * 
//	 */
//     @Bean
//     public MessageChannel outChannel() 
//     {
//    	     return new DirectChannel();
//     }
//     
//     @Bean
//     public MessageHandler mqttOutbound() {
//    	     MqttPahoMessageHandler messageHandler=new MqttPahoMessageHandler("siSamplePublisher", mqttPahoClientFactory());
//    	     messageHandler.setAsync(true);
//    	     messageHandler.setDefaultTopic("siSampleTopic");
//    	     return messageHandler;
//     }
//     
//     
//     /**
//      * MessagingGateway
//      */
//     public interface MsgWriter
//     {
//    	       void write(String note);
//     }
//}
