package com.traveler.server.only;

import com.traveler.server.FamilyApplicationTests;
import com.traveler.server.mapper.OnlyMapper;
import com.traveler.server.model.entity.Words;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OnlyTest extends FamilyApplicationTests {

    @Autowired
    private OnlyMapper onlyMapper;

    @Test
    public void add(){
        List<Words> wordsList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Words words = new Words();
            words.setWord("单词:"+i);
            wordsList.add(words);
        }

//        List<String> wordsList = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            String s = "单词:"+(i+1);
//            wordsList.add(s); 8800 6800
//        }
        onlyMapper.addList(wordsList);
    }
}
