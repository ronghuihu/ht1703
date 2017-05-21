package cn.tarena.ht.test;

import cn.tarena.ht.utils.Encrypt;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/31.
 */
public class Test1 {

    @Test
    public void test1(){
        System.out.println(Encrypt.getMd5("123", "及时雨"));
    }
}
