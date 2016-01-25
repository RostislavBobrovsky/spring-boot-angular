CREATE TABLE teacher (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(20) NOT NULL,
  last_name  VARCHAR(20) NOT NULL
);

CREATE TABLE student (
  id          SERIAL PRIMARY KEY,
  first_name  VARCHAR(20) NOT NULL,
  last_name   VARCHAR(20) NOT NULL,
  birth_date  DATE        NOT NULL,
  hostel_live BOOL DEFAULT FALSE
);

CREATE TABLE training_course (
  id         SERIAL PRIMARY KEY,
  teacher_id SERIAL      NOT NULL,
  name       VARCHAR(50) NOT NULL,
  CONSTRAINT teacher_fk FOREIGN KEY (teacher_id)
    REFERENCES teacher (id) MATCH SIMPLE
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX ON training_course (teacher_id);

CREATE TABLE exam (
  id                 SERIAL PRIMARY KEY,
  training_course_id SERIAL    NOT NULL,
  teacher_id         SERIAL,
  date               TIMESTAMP NOT NULL,
  CONSTRAINT exam_teacher_fk FOREIGN KEY (teacher_id)
    REFERENCES teacher (id) MATCH SIMPLE
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT exam_training_course_fk FOREIGN KEY (training_course_id)
    REFERENCES training_course (id) MATCH SIMPLE
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX ON exam (training_course_id);
CREATE INDEX ON exam (teacher_id);

CREATE TABLE exam_student_result (
  id         SERIAL PRIMARY KEY,
  exam_id    SERIAL   NOT NULL,
  student_id SERIAL   NOT NULL,
  teacher_id SERIAL,
  date       TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
  result     SMALLINT NOT NULL CHECK (result > 0),
  note       VARCHAR(255) DEFAULT NULL,
  CONSTRAINT exam_result_exam_fk FOREIGN KEY (exam_id)
    REFERENCES exam (id) MATCH SIMPLE
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT exam_result_student_fk FOREIGN KEY (student_id)
    REFERENCES student (id) MATCH SIMPLE
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT exam_result_teacher_fk FOREIGN KEY (teacher_id)
    REFERENCES teacher (id) MATCH SIMPLE
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX ON exam_student_result (teacher_id);
CREATE INDEX ON exam_student_result (student_id);
CREATE INDEX ON exam_student_result (exam_id);