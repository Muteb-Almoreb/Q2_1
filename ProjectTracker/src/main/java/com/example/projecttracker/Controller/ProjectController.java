package com.example.projecttracker.Controller;

import com.example.projecttracker.API.ApiRespon;
import com.example.projecttracker.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/projecttracker")
public class ProjectController {


    ArrayList<Project> Projects = new ArrayList<>();



    @GetMapping("/get")
    public ArrayList<Project> getProject() {
        return Projects;
    }


    @PostMapping("/add")
    public ApiRespon addProject(@RequestBody Project project) {
        ApiRespon respone = new ApiRespon("", "");

        for (Project p : Projects) {
            if (p.getId().equals(project.getId())) {
                return new ApiRespon("Project already exists", "400 Bad Request");
            }
        }


        Projects.add(project);
        respone.setMessage("Project added successfully");
        respone.setStatus("200 Ok");


        return respone;
    }


    @PutMapping("/update/{id}")
    public ApiRespon updateProject(@PathVariable String id, @RequestBody Project updatedProject) {
        ApiRespon respone = new ApiRespon("", "");
        for (int i = 0; i < Projects.size(); i++) {
            if (Projects.get(i).getId().equals(id)) {
                Projects.set(i, updatedProject);
                respone.setMessage("Project updated successfully");
                respone.setStatus("200 Ok");
                return respone;
            }
        }
        respone.setMessage("Project not found");
        respone.setStatus("404 Not Found");
        return respone;
    }


    @DeleteMapping("/delete/{id}")
    public ApiRespon deleteProject(@PathVariable String id) {
        ApiRespon respone = new ApiRespon("", "");
        for (int i = 0; i < Projects.size(); i++) {
            if (Projects.get(i).getId().equals(id)) {
                Projects.remove(i);
                respone.setMessage("Project deleted successfully");
                respone.setStatus("200 Ok");
                return respone;
            }
        }
        respone.setMessage("Project not found");
        respone.setStatus("404 Not Found");
        return respone;
    }


    @PutMapping("/changeStatus/{id}")
    public ApiRespon changeStatus(@PathVariable String id, @RequestBody String newStatus) {

        ApiRespon respone = new ApiRespon("", "");
        for (Project p : Projects) {
            if (p.getId().equals(id)) {
                p.setStatus(newStatus);
                respone.setMessage("Project changed successfully");
                respone.setStatus("200 Ok");
                return respone;
            }
        }
        respone.setMessage("Project not found");
        respone.setStatus("404 Not Found");
        return respone;
    }


    @GetMapping("/search/{title}")
    public ApiRespon  searchByTitle(@PathVariable String title) {
        for (Project p : Projects) {
            if (p.getTitle().equalsIgnoreCase(title)) {
                return new ApiRespon("Project found", "200 OK", p);
            }
        }
        return new ApiRespon("Project not found", "404 Not Found", null);
    }


    @GetMapping("/company/{companyName}")
    public ArrayList<Project> getProjectsByCompany(@PathVariable String companyName) {
        ArrayList<Project> result = new ArrayList<>();
        for (Project p : Projects) {
            if (p.getCompanyName().equalsIgnoreCase(companyName)) {
                result.add(p);
            }
        }
        return result;
    }

}