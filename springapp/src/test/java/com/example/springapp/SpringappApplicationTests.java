package com.example.springapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

@Order(1)
@Test
void testAddchildren() throws Exception {
    String requestBody = "{\"babyId\": 1, \"babyFirstName\": \"raj\", \"babyLastName\": \"bhr\", \"fatherName\": \"yer\", \"motherName\": \"nmvb\", \"address\": \"mkwer\"}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/children")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.babyFirstName").value("raj"))
            .andReturn();
}


    @Order(2)
    @Test
    void testGetSortedChildren() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/children/sortBy/babyFirstName")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Order(3)
    @Test
    void testGetPagination() throws Exception {
		int a = 0;
		int b = 3;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/children/{a}/{b}",a , b)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Order(4)
    @Test
    void testGetPaginationAndSorting() throws Exception {
		int c = 0;
		int d = 3;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/children/{c}/{d}/babyFirstName",c , d)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

     @Order(5)
	 @Test

    public void controllerfolder() {

        String directoryPath = "src/main/java/com/example/springapp/controller"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

    @Order(6)
	@Test

    public void controllerfile() {

        String filePath = "src/main/java/com/example/springapp/controller/ChildrenController.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

    @Order(7)
	@Test

    public void testModelFolder() {

        String directoryPath = "src/main/java/com/example/springapp/model"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

    @Order(8)
	@Test

    public void testModelFile() {

        String filePath = "src/main/java/com/example/springapp/model/Children.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


    @Order(9)
	@Test

    public void testrepositoryfolder() {

        String directoryPath = "src/main/java/com/example/springapp/repository"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   
    @Order(10)
    @Test

    public void testrepositoryFile() {

        String filePath = "src/main/java/com/example/springapp/repository/ChildrenRepo.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


    
    @Order(11)
    @Test

    public void testServiceFolder() {

        String directoryPath = "src/main/java/com/example/springapp/service"; 

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   
    @Order(12)
    @Test

    public void testServieFile() {

        String filePath = "src/main/java/com/example/springapp/service/ChildrenService.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }






}
