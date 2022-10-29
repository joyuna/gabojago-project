package com.bitcamp.gabojago.service;

import com.bitcamp.gabojago.dao.ExhibitionDao;
import com.bitcamp.gabojago.vo.Exhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultExhibitionService implements ExhibitionService  {
  @Autowired
  ExhibitionDao exhibitionDao;

  public List<Exhibition> exhibitionList() throws Exception {
    return exhibitionDao.exhibitionList();
  }

  public Exhibition exhibitionSelect(int exno) throws Exception{
    return exhibitionDao.exhibitionSelect(exno);
  }

  @Transactional
  @Override
  public void insert(Exhibition exhibition) throws Exception {
    // 1) 게시글 등록
    if (exhibitionDao.exhibitionInsert(exhibition) == 0) {
      throw new Exception("게시글 등록 실패!");
    }

    // 2) 첨부파일 등록 나중에 생성
  /*  if (exhibition.getAttachedFiles().size() > 0) {
      exhibitionDao.insertFiles(exhibition);
    }*/

  }
}

