package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //GIVEN
        TaskDto taskDto = new TaskDto((long) 1, "title1", "content1");
        //WHEN
        Task task = taskMapper.mapToTask(taskDto);
        //THEN
        Assert.assertEquals(taskDto.getId(), task.getId());
        Assert.assertEquals(taskDto.getTitle(), task.getTitle());
    }

    @Test
    void mapToTaskDto() {
        //GIVEN
        Task task = new Task((long) 11, "title11", "content11");
        //WHEN
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //THEN
        Assert.assertEquals(task.getId(), taskDto.getId());
        Assert.assertEquals(task.getTitle(), taskDto.getTitle());
    }

    @Test
    void mapToTaskDtoList() {
        //GIVEN
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task((long) 11, "title11", "content11"));

        //WHEN
        List<TaskDto> mapppedList = taskMapper.mapToTaskDtoList(taskList);

        //THEN
        Assert.assertEquals(taskList.get(0).getId(), mapppedList.get(0).getId());
        Assert.assertEquals(mapppedList.size(), 1);
    }
}