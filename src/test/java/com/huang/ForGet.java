package com.huang;

import com.huang.flushphoto.util.HttpClientUtil;
import org.junit.Test;

/**
 * @Author huangjihui
 * @Date 2018/8/24 11:13
 */
public class ForGet {
    @Test
    public void getPhotos() throws InterruptedException {
        int start = 0;
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.println(i);
            HttpClientUtil.httpGet("http://surcehuang.ticp.net:8901/flushphoto/downPhotos?page=10&start=" + (start + i * 100));
            Thread.sleep(5000L);
        }

    }
}
