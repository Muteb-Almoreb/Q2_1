package com.example.eventsystem_lap5.Controller;
import com.example.eventsystem_lap5.API.ApiResbonse;
import com.example.eventsystem_lap5.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("get")
    public ApiResbonse getAllEvents()
    {
        return new ApiResbonse("All events retrieved", "200 OK", events);

    }

    @PostMapping("/add")
    public ApiResbonse addEvent(@RequestBody Event event) {
        for (Event e : events) {
            if (e.getId().equals(event.getId())) {
                return new ApiResbonse("Event already exists", "400 Bad Request", null);
            }
        }
        events.add(event);
        return new ApiResbonse("Event added successfully", "200 OK", event);
    }



    @PutMapping("/update/{id}")
    public ApiResbonse updateEvent(@PathVariable String id, @RequestBody Event updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(id)) {
                events.set(i, updatedEvent);
                return new ApiResbonse("Event updated successfully", "200 OK", updatedEvent);
            }
        }
        return new ApiResbonse("Event not found", "404 Not Found", null);
    }


    @DeleteMapping("/delete/{id}")
    public ApiResbonse deleteEvent(@PathVariable String id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(id)) {
                events.remove(i);
                return new ApiResbonse("Event deleted successfully", "200 OK", null);
            }
        }
        return new ApiResbonse("Event not found", "404 Not Found", null);
    }


    @PutMapping("/changeCapacity/{id}")
    public ApiResbonse changeCapacity(@PathVariable String id, @RequestBody int newCapacity) {
        for (Event e : events) {
            if (e.getId().equals(id)) {
                e.setCapacity(newCapacity);
                return new ApiResbonse("Capacity updated successfully", "200 OK", e);
            }
        }
        return new ApiResbonse("Event not found", "404 Not Found", null);
    }




    @GetMapping("/search/{id}")
    public ApiResbonse searchById(@PathVariable String id) {
        for (Event e : events) {
            if (e.getId().equals(id)) {
                return new ApiResbonse("Event found", "200 OK", e);
            }
        }
        return new ApiResbonse("Event not found", "404 Not Found", null);
    }




}
