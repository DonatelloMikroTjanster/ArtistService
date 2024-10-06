package org.example.edufyalbumforartist.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.edufyalbumforartist.entities.Album;
import org.example.edufyalbumforartist.entities.Artist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String artistJson;
    private String expectedArtistJson;


    @BeforeEach
    void setUp() throws JsonProcessingException {
        Artist artistIn = new Artist();
        artistIn.setName("Test Artist");

        Artist expectedArtistReturn = new Artist();
        expectedArtistReturn.setId(1L);
        expectedArtistReturn.setName("Test Artist");

        artistJson = objectMapper.writeValueAsString(artistIn);
        expectedArtistJson = objectMapper.writeValueAsString(expectedArtistReturn);
    }

    //ej fungerande
    @Test
    void testGetAlbumsByArtistReturnsOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(artistJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


        String expectedAlbumsListJson = objectMapper.writeValueAsString(List.of(new Album("Album 1"), new Album("Album 2")));

        mockMvc.perform(MockMvcRequestBuilders.get("/artist/albums/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedAlbumsListJson));
    }


    @Test
    void testGetAllArtistsReturnsStatusOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(artistJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        String expectedJsonArtistList = objectMapper.writeValueAsString(List.of(objectMapper.readValue(expectedArtistJson, Artist.class)));

        mockMvc.perform(MockMvcRequestBuilders.get("/artist/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJsonArtistList));
    }

    @Test
    void testAddArtistReturnsStatusOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(artistJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedArtistJson));
    }

    @Test
    void testDeleteArtistReturnsStatusOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(artistJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.delete("/artist/delete-artist/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Test Artist has been deleted."));
    }


    @Test
    void testUpdateArtistReturnsStatusOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(artistJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Artist updatedArtist = new Artist();
        updatedArtist.setName("Updated Artist");
        String updatedArtistJson = objectMapper.writeValueAsString(updatedArtist);

        Artist expectedUpdatedArtist = new Artist();
        expectedUpdatedArtist.setId(1L);
        expectedUpdatedArtist.setName("Updated Artist");
        String expectedUpdatedArtistJson = objectMapper.writeValueAsString(expectedUpdatedArtist);

        mockMvc.perform(MockMvcRequestBuilders.put("/artist/update-artist/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedArtistJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedUpdatedArtistJson));
    }
}