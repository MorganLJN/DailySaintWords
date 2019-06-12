package com.lizehao.watermelondiarynew.PhotoWall;

import com.lizehao.watermelondiarynew.R;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by mi on 2019/4/16.
 */

public class image {

    public final static String[] imageThumbUrls = new String[] {
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/1.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/2%E8%8A%82%E6%97%A5-%E8%85%8A%E5%85%AB.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/3.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/4.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/5%E4%BA%AC%E5%89%A7-%E5%8F%B8%E9%A9%AC%E5%B8%88GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/6.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/7%E8%8A%82%E6%B0%94-%E5%B0%8F%E5%AF%92GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/8.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/9.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/10GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/11.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/12%E5%8F%A4%E4%B9%90%E5%99%A8-%E5%8F%A4%E7%90%B4GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/13.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/14%E4%BA%AC%E5%89%A7-%E9%BB%84%E5%BF%A0GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/15.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/16.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/17%E4%B9%A6%E6%B3%95-%E9%A2%9C%E7%9C%9F%E5%8D%BF-%E9%A2%9C%E5%8B%A4%E7%A4%BC%E7%A2%91-%E6%A5%B7%E4%B9%A6.png",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/18.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/19.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/20.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/21.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/22%E8%8A%82%E6%B0%94-%E5%A4%A7%E5%AF%92GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/23.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/24%E8%8A%82%E6%97%A5-%E9%99%A4%E5%A4%95.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/25%E8%8A%82%E6%97%A5-%E6%98%A5%E8%8A%82.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/26.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/27%E7%9F%B3%E9%BC%93%E6%96%87-%E5%B0%8F%E7%AF%86.png",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/28.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/29.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/30.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/31%E5%8F%A4%E4%B9%90%E5%99%A8-%E5%8F%A4%E7%AD%9DGIF.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0201%E5%8F%A4%E7%94%BB-%E5%8D%97%E5%8C%97%E6%B4%BE.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0202.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0203.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0204%E8%8A%82%E6%B0%94-%E7%AB%8B%E6%98%A5GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0205.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0206.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0207.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0208%E8%8A%82%E6%97%A5-%E5%85%83%E5%AE%B5.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0209.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0210.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0211.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0212%E4%BA%AC%E5%89%A7-%E9%9F%A9%E4%B8%96%E5%BF%A0GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0213.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0214.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0215.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0216%E5%8F%A4%E7%94%BB-%E8%8A%B1%E9%B8%9F%E7%94%BB.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0217.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0218.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0219%E8%8A%82%E6%B0%94-%E9%9B%A8%E6%B0%B4GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0220.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0221.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0222.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0223%E5%8F%A4%E4%B9%90%E5%99%A8-%E8%83%A1%E7%90%B4GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0224.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0225.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0226%E4%B9%A6%E6%B3%95-%E5%BE%90%E6%96%87%E9%92%A6-%E5%BC%A0%E8%BF%81%E7%A2%91-%E9%9A%B6%E4%B9%A6.png",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0227.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0228.jpg",
            "http://kan.027cgb.com/619969/%E4%BA%8C%E6%9C%88/0229%E5%8F%A4%E4%B9%90%E5%99%A8-%E9%94%A6%E7%91%9FGIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0301.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0302.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0303.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0304.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0305%E8%8A%82%E6%B0%94-%E6%83%8A%E8%9B%B0GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0306.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0307%E4%B9%A6%E6%B3%95-%E7%8E%8B%E7%BE%B2%E4%B9%8B-%E5%85%B0%E4%BA%AD%E9%9B%86%E5%BA%8F-%E8%A1%8C%E4%B9%A6.png",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0308.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0309%E7%9A%AE%E5%BD%B1-%E5%8C%97%E4%BA%AC%E7%9A%AE%E5%BD%B1GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0310.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0311.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0312%E5%9B%BD%E7%94%BB-%E9%BB%84%E6%B4%BE.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0313.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0314.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0315%E5%8F%A4%E4%B9%90%E5%99%A8-%E7%90%B5%E7%90%B6GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0316.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0317%E7%9A%AE%E5%BD%B1-%E9%99%95%E8%A5%BF%E7%9A%AE%E5%BD%B1GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0318.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0319.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0320%E8%8A%82%E6%B0%94-%E6%98%A5%E5%88%86GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0321%E5%8F%A4%E4%B9%90%E5%99%A8-%E5%9F%99GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0322.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0323.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0324%E7%9A%AE%E5%BD%B1-%E6%B5%B7%E5%AE%81%E7%9A%AE%E5%BD%B1GIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0325.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0326%E6%A3%8B-%E5%9B%B4%E6%A3%8BGIF.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0327.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0328.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0329.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0330.jpg",
            "http://kan.027cgb.com/619969/%E4%B8%89%E6%9C%88/0331%E5%8F%A4%E4%B9%90%E5%99%A8-%E6%A3%8BGIF.jpg"
    };



    public static boolean[] collection = new boolean[]{
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false,
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,
            false,
            false
    };



}