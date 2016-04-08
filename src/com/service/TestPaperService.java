package com.service;

import com.mapper.TestPaperMapper;
import com.models.Teacher;
import com.models.TestPaper;
import com.models.TestPaperExample;

import java.util.List;

public class TestPaperService {
    private TestPaperMapper testPaperMapper;

    public TestPaperMapper getTestPaperMapper() {
        return testPaperMapper;
    }

    public void setTestPaperMapper(TestPaperMapper testPaperMapper) {
        this.testPaperMapper = testPaperMapper;
    }

    public void addPaper(TestPaper testPaper){
        testPaperMapper.insert(testPaper);
    }

    public void deletePaper(int id){
        testPaperMapper.deleteByPrimaryKey(id);
    }

    public TestPaper modifyPaper(int id){
        TestPaper testPaper = testPaperMapper.selectByPrimaryKey(id);
        return testPaper;
    }

    public void updatePaper(TestPaper testPaper){
        testPaperMapper.updateByPrimaryKeySelective(testPaper);
    }

    public List<TestPaper> findPapers(String paperName){
        TestPaperExample testPaperExample = new TestPaperExample();
        TestPaperExample.Criteria criteria = testPaperExample.createCriteria();
        criteria.andTestNameLike(paperName);
        List<TestPaper> list = testPaperMapper.selectByExample(testPaperExample);
        return list;
    }

    public List<TestPaper> getAllPapers(){
        TestPaperExample testPaperExample = new TestPaperExample();
        TestPaperExample.Criteria criteria = testPaperExample.createCriteria();
        criteria.andIdIsNotNull();
        List<TestPaper> list = testPaperMapper.selectByExample(testPaperExample);
        return list;
    }

    public List<TestPaper> getStuPaper(List<Integer> paperIds){
        TestPaperExample testPaperExample = new TestPaperExample();
        TestPaperExample.Criteria criteria = testPaperExample.createCriteria();
        for(int i = 0;i<paperIds.size();i++){
            criteria = criteria.andIdNotEqualTo(paperIds.get(i));
        }
        List<TestPaper> list = testPaperMapper.selectByExample(testPaperExample);
        return list;
    }
}
