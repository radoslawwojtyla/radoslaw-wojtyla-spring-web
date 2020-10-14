package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TrelloMapperTest {

    private List<TrelloListDto> trelloListDtos = new ArrayList<>();
    private List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
    private List<TrelloList> trelloLists = new ArrayList<>();
    private List<TrelloBoard> trelloBoards = new ArrayList<>();

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoards() {
        //GIVEN
        trelloListDtos.add(new TrelloListDto("trellodto1", "trellonamedto1", false));
        trelloBoardDtos.add(new TrelloBoardDto("boarddto1", "bardnamedto1", trelloListDtos));

        //WHEN
        List<TrelloBoard> mapppedList = trelloMapper.mapToBoards(trelloBoardDtos);

        //THEN
        Assert.assertEquals(trelloBoardDtos.get(0).getName(), mapppedList.get(0).getName());
        Assert.assertEquals(trelloBoardDtos.size(), 1);
    }

    @Test
    void mapToBoardsDto() {
        //GIVEN
        trelloLists.add(new TrelloList("trello1", "trelloname1", false));
        trelloBoards.add(new TrelloBoard("board1", "bardname1", trelloLists));

        //WHEN
        List<TrelloBoardDto> mapppedList = trelloMapper.mapToBoardsDto(trelloBoards);

        //THEN
        Assert.assertEquals(trelloBoards.get(0).getName(), mapppedList.get(0).getName());
        Assert.assertEquals(trelloBoards.size(), 1);
    }

    @Test
    void mapToList() {
        //GIVEN
        trelloListDtos.add(new TrelloListDto("trellodto1", "trellonamedto1", false));

        //WHEN
        List<TrelloList> mapppedList = trelloMapper.mapToList(trelloListDtos);

        //THEN
        Assert.assertEquals(trelloListDtos.get(0).getName(), mapppedList.get(0).getName());
        Assert.assertEquals(trelloListDtos.size(), 1);
    }

    @Test
    void mapToListDto() {
        //GIVEN
        trelloLists.add(new TrelloList("trello1", "trelloname1", false));

        //WHEN
        List<TrelloListDto> mapppedList = trelloMapper.mapToListDto(trelloLists);

        //THEN
        Assert.assertEquals(trelloLists.get(0).getName(), mapppedList.get(0).getName());
        Assert.assertEquals(trelloLists.size(), 1);
    }

    @Test
    void mapToCardDto() {
        //GIVEN
        TrelloCard card = new TrelloCard("card1", "desc1", "pos1", "listId1");

        //WHEN
        TrelloCardDto mapppedCard = trelloMapper.mapToCardDto(card);

        //THEN
        Assert.assertEquals(card.getName(), mapppedCard.getName());
    }

    @Test
    void mapToCard() {
        //GIVEN
        TrelloCardDto card = new TrelloCardDto("cardDto1", "descDto1", "posDto1", "listIdDto1");

        //WHEN
        TrelloCard mapppedCard = trelloMapper.mapToCard(card);

        //THEN
        Assert.assertEquals(card.getName(), mapppedCard.getName());
    }
}