package com.fsd.springboot.model;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RunWith(SpringRunner.class)
public class ProjectTest {

  @Autowired private JacksonTester<Project> json;

  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(("dd/MM/yyyy"));

  private static final String PROJECT= "Project";
  private static final String START_DATE_STRING = "01/12/2020";
  private static final String END_DATE_STRING = "02/12/2020";
  private static final Date DATE_OF_START = parseDate(START_DATE_STRING);
  private static final Date DATE_OF_END = parseDate(END_DATE_STRING);
  private static final int PRIORITY = 1;
 

  private static final String JSON_TO_DESERIALIZE =
      "{\"project\":\""
          + PROJECT
          + "\",\"start_Date\":\""
          + START_DATE_STRING
          + "\",\"end_Date\":\""
          + END_DATE_STRING
          + "\",\"priority\":"
          + PRIORITY
          + "}";

  private Project project;

  private static Date parseDate(final String dateString) {
    try {
      return simpleDateFormat.parse(dateString);
    } catch (final ParseException e) {
      return new Date();
    }
  }

  @Before
  public void setup() throws ParseException {
	  project = new Project(PROJECT, DATE_OF_START, DATE_OF_END, PRIORITY);
  }

  @Test
  public void projectSerializes() throws IOException {
    assertThat(this.json.write(project))
        .extractingJsonPathStringValue("@.project")
        .isEqualTo(PROJECT);
  }

 /* @Test
  public void start_DateSerializes() throws IOException, ParseException {
    assertThat(this.json.write(project))
        .extractingJsonPathStringValue("@.start_Date")
        .isEqualTo(START_DATE_STRING);
  }
  @Test
  public void end_DateSerializes() throws IOException, ParseException {
    assertThat(this.json.write(project))
        .extractingJsonPathStringValue("@.end_Date")
        .isEqualTo(END_DATE_STRING);
  }
*/
  @Test
  public void prioritySerializes() throws IOException {
    assertThat(this.json.write(project))
        .extractingJsonPathNumberValue("@.priority")
        .isEqualTo(PRIORITY);
  }



  @Test
  public void projectDeserializes() throws IOException {
    assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getProject()).isEqualTo(PROJECT);
  }

/*
  @Test
  public void start_DateDeserializes() throws IOException {
    assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getStart_Date())
        .isEqualTo(DATE_OF_START);
  }
  
  @Test
  public void end_DateDeserializes() throws IOException {
    assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getEnd_Date())
        .isEqualTo(DATE_OF_END);
  }
*/
  @Test
  public void priorityDeserializes() throws IOException {
    assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getPriority()).isEqualTo(PRIORITY);
  }

  
}

