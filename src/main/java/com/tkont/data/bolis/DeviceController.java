package com.tkont.data.bolis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by iakoupov on 2019-08-19.
 */

@RestController
public class DeviceController {

    @RequestMapping("/device-data")
    public DeviceData requestData() {
        DeviceData data = new DeviceData();
        data.setItemProcessingId(12);
        data.setName("Turbine shaft x54");
        data.setStart(new Date());
        data.setOperationCapacity(30);
        data.setTemp(75);
        return data;
    }
    
    @RequestMapping("/device-data-special")
    public DeviceData requestSpecialData() {
        DeviceData data = new DeviceData();
        data.setItemProcessingId(345);
        data.setName("Circular Saw v58");
        data.setStart(new Date());
        data.setOperationCapacity(50);
        data.setTemp(95);
        return data;
    }
    
    @RequestMapping("/all-data")
    public DeviceData[] requestAllData() {
        DeviceData data = new DeviceData();
        data.setItemProcessingId(12);
        data.setName("Turbine shaft x54");
        data.setStart(new Date());
        data.setOperationCapacity(30);
        data.setTemp(75);

        DeviceData data1 = new DeviceData();
        data1.setItemProcessingId(12);
        data1.setName("Turbine shaft x54");
        data1.setStart(new Date());
        data1.setOperationCapacity(30);
        data1.setTemp(75);

        DeviceData data2 = new DeviceData();
        data2.setItemProcessingId(12);
        data2.setName("Turbine shaft x54");
        data2.setStart(new Date());
        data2.setOperationCapacity(30);
        data2.setTemp(75);
        
        return new DeviceData[] {data, data1, data2};
    }

    @RequestMapping("/device-data-live")
    public SseEmitter requestLiveData() {
        Timer timer = new Timer();
        Random random = new Random();
        SseEmitter emitter = new SseEmitter();
        TimerTask dispatcher = new TimerTask() {
            @Override
            public void run() {
                DeviceData data = new DeviceData();
                data.setItemProcessingId(random.nextInt(1000) + 1000);
                data.setName("Turbine shaft x54");
                data.setStart(new Date());
                data.setOperationCapacity(random.nextInt(100));
                data.setTemp(random.nextInt(500) + 50);
                try {
                    emitter.send(data);
                } catch (IOException exception) {
                    System.out.println(exception);
                    emitter.completeWithError(exception);
                }
            }
        };
        timer.scheduleAtFixedRate(dispatcher, 0, 300);
        return emitter;
    }
}
