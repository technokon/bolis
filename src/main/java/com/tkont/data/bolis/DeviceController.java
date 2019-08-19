package com.tkont.data.bolis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
}
