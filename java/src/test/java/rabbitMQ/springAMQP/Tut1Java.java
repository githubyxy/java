package rabbitMQ.springAMQP;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

@RabbitListener(queues = "hello")
public class Tut1Java {

	public static void main(final String... args) throws Exception {

		CachingConnectionFactory cf = new CachingConnectionFactory();
		cf.setAddresses("192.168.1.7:5672");
		cf.setUsername("admin");
		cf.setPassword("admin");
        
		// set up the queue, exchange, binding on the broker
		RabbitAdmin admin = new RabbitAdmin(cf);
		Queue queue = new Queue("myQueue");
		admin.declareQueue(queue);
		TopicExchange exchange = new TopicExchange("myExchange");
		admin.declareExchange(exchange);
		admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("foo.*"));

		// set up the listener and container
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
		Object listener = new Object() {
			// 接受到消息时，会执行此方法
			public void handleMessage(String foo) {
				System.out.println("Tut1Java " + foo);
			}
			public void handleMessage2(String foo) {
				System.out.println("Tut1Java2 " + foo);
			}
		};
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		adapter.setDefaultListenerMethod("handleMessage2");
		container.setMessageListener(adapter);
		container.setQueueNames("myQueue");
		container.start();

		// send something
		RabbitTemplate template = new RabbitTemplate(cf);
		// 只有routingKey符合foo.*规则的才会被接受处理
		template.convertAndSend("myExchange", "foo.bar", "Hello, world!");
		container.stop();
	}
}