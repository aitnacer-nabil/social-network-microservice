package com.nabilaitnacer.servicepost.client;

import com.nabilaitnacer.servicepost.dto.MediaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(url = "http://localhost:8016/api/v1/medias",name = "media-service")
public interface MediaClient {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<List<MediaDTO>> add(@RequestPart("files") List<MultipartFile> files,
                                       @RequestParam("postId") Long postId,@RequestParam("userId") Long userId);
    @DeleteMapping("/post/{postId}")
    void deleteMedia(@PathVariable("postId") Long postId);

    @GetMapping("/post/{postId}")
    List<MediaDTO> getMediaByPostId(@PathVariable("postId") Long postId);

    @DeleteMapping
     ResponseEntity<Void> deleteMedia(@RequestParam("userId") Long userId,
                                            @RequestParam("mediaId") Long mediaId,
                                            @RequestParam("postId") Long postId
    );

}
