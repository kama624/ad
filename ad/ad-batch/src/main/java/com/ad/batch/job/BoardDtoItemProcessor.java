package com.ad.batch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.ad.dto.BoardDto;

public class BoardDtoItemProcessor implements ItemProcessor<BoardDto, BoardDto> {

	  private static final Logger log = LoggerFactory.getLogger(BoardDtoItemProcessor.class);

	  @Override
	  public BoardDto process(final BoardDto boardDto) throws Exception {
//	    final String firstName = person.getFirstName().toUpperCase();
//	    final String lastName = person.getLastName().toUpperCase();

		String title =   boardDto.getTitle() + " 변경 " ;
		log.debug("   title >> : " + title);
		log.debug("   title >> : " + title);
		log.debug("   title >> : " + title);
		log.debug("   title >> : " + title);
	    final BoardDto transformedPerson = new BoardDto(boardDto.getBno(), title,  boardDto.getContent(),  boardDto.getWriter(),  boardDto.getRegdate());

	    log.info("Converting (" + boardDto + ") into (" + transformedPerson + ")");

	    return transformedPerson;
	  }

	}