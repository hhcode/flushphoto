package com.huang.flushphoto.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huang.flushphoto.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huangjihui
 * @Date 2018/8/22 18:30
 */
@RestController
@RequestMapping("/flushphoto")
public class FlushPhotoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlushPhotoController.class);

    @RequestMapping("/downPhotos")
    public void downPhotos() {
        JSONObject photoJson = HttpClientUtil.httpGet(getUrl(6, 0, 10));
        getPhotosByJson(photoJson);
    }

    private void getPhotosByJson(JSONObject photoJson) {
        JSONArray photoArray = photoJson.getJSONArray("data");
        for (int i = 0; i < photoArray.size(); i++) {
            JSONObject photoData = photoArray.getJSONObject(i);
            String photoUrl = photoData.getString("url_mobile");
            LOGGER.info(photoUrl);
            HttpClientUtil.download(photoUrl,"D:\\photos\\" + i+".jpg");
        }
    }

    private String getUrl(int cid, int start, int count) {
        StringBuffer sb = new StringBuffer();
        sb.append("http://wallpaper.apc.360.cn/index.php?c=WallPaper&a=getAppsByCategory&cid=").append(cid).append("&start=").append(start).append("&count=").append(count).append("&from=360chrome");
        return sb.toString();
    }
}
