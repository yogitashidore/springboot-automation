package net.shadervertex.sms;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import net.shadervertex.sms.service.StudentService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    private static final String END_POINT_PATH = "/students"; // Update the endpoint path

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService; // Mock the StudentService

    @Test
    public void testGetStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH))
               .andExpect(status().isOk());
    }
    
    @Test
    public void testGetStudentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(redirectedUrl(END_POINT_PATH)); // Update the expected redirected URL here
    }

    @Test
    public void testDeleteNonExistingStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(END_POINT_PATH + "/{id}", 999L))
               .andExpect(status().isMethodNotAllowed()); // Expecting 405 Method Not Allowed
    }
}
