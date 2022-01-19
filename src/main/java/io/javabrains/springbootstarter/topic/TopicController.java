package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.hello.HelloController;

@RestController
public class TopicController {

	private static final Logger logger = LoggerFactory.getLogger( TopicController.class );
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		logger.trace("TopicController : trace : topic()");
		logger.debug("TopicController : debug : topic()");
		logger.info("TopicController : info : topic()");
		logger.warn("TopicController : warn : topic()");
		logger.error("TopicController : error : topic()");			
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic( @RequestBody Topic topic) {
		topicService.addTopic( topic );

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic( @RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic( id, topic );

	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}	

}
