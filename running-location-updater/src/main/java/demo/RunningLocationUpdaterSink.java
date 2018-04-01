package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.CurrentPosition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.concurrent.ThreadLocalRandom;

@MessageEndpoint
@EnableBinding(Sink.class)
@Slf4j
public class RunningLocationUpdaterSink {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void updateLocationAddServiceLocations(String input) throws Exception {
        log.info("Location input in updater: " + input);
        CurrentPosition payload = this.objectMapper.readValue(input, CurrentPosition.class);
        payload.setHeartRate(generateHeartRate());
        this.template.convertAndSend("/topic/locations", payload);
    }

    private int generateHeartRate() {
        return ThreadLocalRandom.current().nextInt(50, 160);
    }
}
