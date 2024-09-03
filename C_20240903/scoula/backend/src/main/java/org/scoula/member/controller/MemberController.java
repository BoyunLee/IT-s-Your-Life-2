package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;

    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(service.checkDuplicate(username));
    }

    @GetMapping("/{username}")
    public ResponseEntity<MemberDTO> get(@PathVariable String username) {
        return ResponseEntity.ok(service.get(username));
    }

    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response) {
        String avatarPath = "c:/upload/avatar/" + username + ".png";
        File file = new File(avatarPath);
        if(!file.exists()) {
            file = new File("C:/upload/avatar/unknown.png");
        }
        UploadFiles.downloadImage(response, file);
    }


    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member) {
        return ResponseEntity.ok(service.join(member));
    }

    @PutMapping("/{username}/changepassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        service.changePassword(changePasswordDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {
        return ResponseEntity.ok(service.update(member));
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<MemberDTO> delete(@PathVariable String username) {
        return ResponseEntity.ok(service.delete(username));
    }
}
