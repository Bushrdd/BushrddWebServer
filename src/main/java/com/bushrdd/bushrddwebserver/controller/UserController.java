package com.bushrdd.bushrddwebserver.controller;

import com.bushrdd.bushrddwebserver.pojo.Songs;
import com.bushrdd.bushrddwebserver.pojo.VoiceRoomConfigurations;
import com.bushrdd.bushrddwebserver.pojo.VoiceRoomUsers;
import com.bushrdd.bushrddwebserver.service.UserServiceImpl;
import com.bushrdd.bushrddwebserver.utils.VoiceCallTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.bushrdd.bushrddwebserver.utils.Result.ERROR;
import static com.bushrdd.bushrddwebserver.utils.Result.OK;

@RestController
// @CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    // @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    // public String addUser(@RequestParam("username") String username, @RequestParam("password") String password) {
    //     System.out.println(username);
    //     System.out.println(password);
    //     // userService.addUser(username, password);
    //     userService.findUserByName(username);
    //     return OK();
    // }

    // @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    // public String addUser(@RequestBody Map<String, String> requestData) {
    //     String username = requestData.get("username");
    //     String password = requestData.get("password");
    //
    //     System.out.println(username);
    //     System.out.println(password);
    //     // userService.addUser(username, password);
    //     userService.findUserByName(username);
    //
    //     return OK();
    // }

    @RequestMapping(value = "/getSongList", method = RequestMethod.GET)
    public String getSongList() {
        // String username = requestData.get("username");
        // String password = requestData.get("password");

        // System.out.println(username);
        // System.out.println(password);
        // userService.addUser(username, password);
        List<Songs> songs = userService.getSongList();

        return OK(songs);
    }

    @RequestMapping(value = "/setTodaySong", method = RequestMethod.POST)
    public String setTodaySong(@RequestBody Map<String, Integer> requestData) {
        int id = requestData.get("id");

        System.out.println(id);

        try {
            userService.setTodaySong(id);
        } catch (Exception e) {
            return ERROR();
        }
        return OK();
    }

    @RequestMapping(value = "/movie/getVoiceRoomUsersInfo", method = RequestMethod.GET)
    public String getVoiceRoomUsersInfo() {
        List<VoiceRoomUsers> voiceRoomUsers;
        try {
            voiceRoomUsers = userService.getVoiceRoomUsersInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR(e.getMessage());
        }
        return OK(voiceRoomUsers);
    }

    @RequestMapping(value = "/movie/getVoiceRoomUsersInfoByChannel", method = RequestMethod.GET)
    public String getVoiceRoomUsersInfoByChannel(@RequestParam(name = "channel", required = false) String channel) {
        List<VoiceRoomUsers> voiceRoomUsers;
        try {
            voiceRoomUsers = userService.getVoiceRoomUsersInfoByChannel(channel);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR(e.getMessage());
        }
        return OK(voiceRoomUsers);
    }

    @RequestMapping(value = "/movie/getVoiceRoomConfigurations", method = RequestMethod.GET)
    public String getVoiceRoomConfigurations() {
        List<VoiceRoomConfigurations> voiceRoomConfigurations;
        try {
            voiceRoomConfigurations = userService.getVoiceRoomConfigurations();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR(e.getMessage());
        }
        return OK(voiceRoomConfigurations);
    }

    @RequestMapping(value = "/movie/CreateToken", method = RequestMethod.GET)
    public String CreateToken(@RequestParam(name = "channelName") String channelName) {
        String[] result;
        try {
            if ("".equals(channelName)){
                return ERROR("房间名不可为空！");
            }
            result = VoiceCallTokenManager.createToken(channelName);
            userService.addVoiceCallCon(channelName, result[0], result[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR(e.getMessage());
        }
        return OK(result[0]);
    }
}
