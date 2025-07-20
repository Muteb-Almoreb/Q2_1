    package com.example.student_lap5.Controller;

    import API.ApiRespone;
    import com.example.student_lap5.Model.Student;
    import org.springframework.web.bind.annotation.*;


    import java.util.ArrayList;

    @RestController
    @RequestMapping("api/v1/student")
    public class StudentController {

        ArrayList<Student> students = new ArrayList<>();



        @GetMapping("/get")
        public ArrayList<Student> getStudents() {
            return students;
        }


        @PostMapping("/add")
        public ApiRespone creatStudent(@RequestBody Student student) {
            ApiRespone respone= new ApiRespone("" ,"");


            for (int i = 0; i < students.size(); i++) {

                if (students.get(i).getId().equals(student.getId())) {
                    respone.setMessage("Student already exists");
                    respone.setStatus("200 Ok");


                    return respone;
                }
            }
            students.add(student);
            respone.setMessage("add Student successfully");

            return respone;

        }


        @PutMapping("/update/{id}")
        public ApiRespone updateStudent(@PathVariable String id, @RequestBody Student student) {
            ApiRespone respone= new ApiRespone("" ,"");
            for (int i = 0; i < students.size(); i++) {

                if (students.get(i).getId().equals(id)) {
                    students.set(i, student);
                     respone.setMessage("update Student successfully");
                    return respone;
                }



            }

            respone.setMessage("student not found");
            respone.setStatus("404 Not Found");

            return respone;

        }


        @DeleteMapping("/delete/{id}")
        public ApiRespone deleteStudent(@PathVariable String id) {
            ApiRespone respone= new ApiRespone("" ,"");

            if(students.isEmpty()) {
                respone.setMessage("There is no student to delete");
                return respone;
            }
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(id)) {
                    students.remove(i);
                    respone.setMessage("delete Student successfully");
                    return respone;
                }

            }
            respone.setMessage("delete failed");
            return respone;

        }

        @GetMapping("/getGpa/{id}")
        public ApiRespone GPA(@PathVariable String id) {


            ApiRespone respone= new ApiRespone("" ,"");
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(id)) {

                    if (students.get(i).getGpa() >= 4.51 && students.get(i).getGpa() <= 5) {
                        students.get(i).setGrade("A");
                    } else if (students.get(i).getGpa() >= 3.51 && students.get(i).getGpa() <= 4.50) {
                        students.get(i).setGrade("B");
                    } else if (students.get(i).getGpa() >= 2.51 && students.get(i).getGpa() <= 3.50) {
                        students.get(i).setGrade("C");
                    } else if (students.get(i).getGpa() >= 1.01 && students.get(i).getGpa() <= 2.50) {
                        students.get(i).setGrade("D");
                    } else if (students.get(i).getGpa() >= 0 && students.get(i).getGpa() <= 1) {
                        students.get(i).setGrade("F");
                    }

                     respone.setMessage("The grade of id  "+id+" is "+students.get(i).getGrade());
                        return respone;
                }



            }

            respone.setMessage("Student not found");
            return respone;
        }

        @GetMapping("/getAbAvg")

        public ArrayList<Student> avgGpa() {
            double total = 0;
            for (int i = 0; i < students.size(); i++) {

               total+= students.get(i).getGpa();


                }

            double avg = total/students.size();


            ArrayList<Student> avgGpa = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getGpa() > avg) {
                    avgGpa.add(students.get(i));
                }



            }

            return avgGpa;
        }

    }
