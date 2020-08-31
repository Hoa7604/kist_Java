-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- Roles Table Create SQL
CREATE TABLE Roles
(
    `id`        INT            NOT NULL    AUTO_INCREMENT, 
    `roleName`  VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (id)
);


-- Roles Table Create SQL
CREATE TABLE Users
(
    `id`         INT             NOT NULL    AUTO_INCREMENT, 
    `email`      VARCHAR(255)    NOT NULL, 
    `userName`   VARCHAR(45)     NOT NULL, 
    `password`   VARCHAR(20)     NOT NULL, 
    `fullName`   VARCHAR(45)     NULL, 
    `address`    VARCHAR(255)    NULL, 
    `amount`     DOUBLE          NOT NULL, 
    `birthDate`  DATE            NULL, 
    `role_id`    INT             NOT NULL, 
    `urlImg`     VARCHAR(255)    NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Users
    ADD CONSTRAINT FK_Users_role_id_Roles_id FOREIGN KEY (role_id)
        REFERENCES Roles (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Instructors
(
    `id`              INT             NOT NULL    AUTO_INCREMENT, 
    `user_id`         INT             NOT NULL, 
    `experienceYear`  INT             NOT NULL, 
    `numStudent`      INT             NOT NULL, 
    `rateValue`       INT             NOT NULL, 
    `skillLevel`      VARCHAR(45)     NULL, 
    `urlImg`          VARCHAR(255)    NULL, 
    `about_me`        VARCHAR(255)    NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Instructors
    ADD CONSTRAINT FK_Instructors_user_id_Users_id FOREIGN KEY (user_id)
        REFERENCES Users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Certificates
(
    `id`               INT             NOT NULL    AUTO_INCREMENT, 
    `certificateName`  VARCHAR(45)     NOT NULL, 
    `provider`         VARCHAR(255)    NOT NULL, 
    PRIMARY KEY (id)
);


-- Roles Table Create SQL
CREATE TABLE Category
(
    `id`            INT            NOT NULL    AUTO_INCREMENT, 
    `categoryName`  VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (id)
);


-- Roles Table Create SQL
CREATE TABLE Courses
(
    `id`              INT            NOT NULL    AUTO_INCREMENT, 
    `courseTitle`     VARCHAR(45)    NOT NULL, 
    `description`     VARCHAR(45)    NOT NULL, 
    `priceCourse`     DOUBLE         NOT NULL, 
    `language`        VARCHAR(45)    NOT NULL, 
    `numStudent`      INT            NOT NULL, 
    `createDate`      DATETIME       NOT NULL, 
    `lasteUpdate`     DATETIME       NOT NULL, 
    `courseInfo_id`   INT            NOT NULL, 
    `instructor_id`   INT            NOT NULL, 
    `category_id`     INT            NOT NULL, 
    `certificate_id`  INT            NOT NULL, 
    `urlImg`          VARCHAR(45)    NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Courses
    ADD CONSTRAINT FK_Courses_instructor_id_Instructors_id FOREIGN KEY (instructor_id)
        REFERENCES Instructors (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Courses
    ADD CONSTRAINT FK_Courses_category_id_Category_id FOREIGN KEY (category_id)
        REFERENCES Category (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Courses
    ADD CONSTRAINT FK_Courses_certificate_id_Certificates_id FOREIGN KEY (certificate_id)
        REFERENCES Certificates (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Section
(
    `id`           INT             NOT NULL    AUTO_INCREMENT, 
    `title`        VARCHAR(45)     NOT NULL, 
    `description`  VARCHAR(255)    NOT NULL, 
    `course_id`    INT             NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Section
    ADD CONSTRAINT FK_Section_course_id_Courses_id FOREIGN KEY (course_id)
        REFERENCES Courses (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Test
(
    `id`           INT             NOT NULL    AUTO_INCREMENT, 
    `title`        VARCHAR(255)    NOT NULL, 
    `numQuestion`  INT             NOT NULL, 
    `score`        DOUBLE          NOT NULL, 
    `section_id`   INT             NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Test
    ADD CONSTRAINT FK_Test_section_id_Section_id FOREIGN KEY (section_id)
        REFERENCES Section (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Orders
(
    `id`           INT       NOT NULL    AUTO_INCREMENT, 
    `user_id`      INT       NOT NULL, 
    `createDate`   DATE      NOT NULL, 
    `totalAmount`  DOUBLE    NOT NULL, 
    `status`       INT       NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_user_id_Users_id FOREIGN KEY (user_id)
        REFERENCES Users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE multi_choice
(
    `id`           INT             NOT NULL    AUTO_INCREMENT, 
    `title`        VARCHAR(255)    NOT NULL, 
    `rightAnswer`  INT             NOT NULL, 
    `test_id`      INT             NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE multi_choice
    ADD CONSTRAINT FK_multi_choice_test_id_Test_id FOREIGN KEY (test_id)
        REFERENCES Test (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE essay
(
    `id`       INT             NOT NULL    AUTO_INCREMENT, 
    `title`    VARCHAR(255)    NULL, 
    `test_id`  INT             NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE essay
    ADD CONSTRAINT FK_essay_test_id_Test_id FOREIGN KEY (test_id)
        REFERENCES Test (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE promotion
(
    `id`             INT            NOT NULL    AUTO_INCREMENT, 
    `promotionName`  VARCHAR(45)    NOT NULL, 
    `endDate`        DATE           NOT NULL, 
    `discount`       int            NOT NULL, 
    `startDate`      DATE           NOT NULL, 
    PRIMARY KEY (id)
);


-- Roles Table Create SQL
CREATE TABLE course_order
(
    `order_itemID`  INT    NOT NULL    AUTO_INCREMENT, 
    `course_id`     INT    NOT NULL, 
    `order_id`      INT    NOT NULL, 
    PRIMARY KEY (order_itemID)
);

ALTER TABLE course_order
    ADD CONSTRAINT FK_course_order_course_id_Courses_id FOREIGN KEY (course_id)
        REFERENCES Courses (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE course_order
    ADD CONSTRAINT FK_course_order_order_id_Orders_id FOREIGN KEY (order_id)
        REFERENCES Orders (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Invoice
(
    `invoiceID`   INT         NOT NULL    AUTO_INCREMENT, 
    `createDate`  DATETIME    NOT NULL, 
    `order_id`    INT         NOT NULL, 
    PRIMARY KEY (invoiceID)
);

ALTER TABLE Invoice
    ADD CONSTRAINT FK_Invoice_order_id_Orders_id FOREIGN KEY (order_id)
        REFERENCES Orders (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Rating
(
    `id`         INT    NOT NULL    AUTO_INCREMENT, 
    `rateValue`  INT    NOT NULL, 
    `course_id`  INT    NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Rating
    ADD CONSTRAINT FK_Rating_course_id_Courses_id FOREIGN KEY (course_id)
        REFERENCES Courses (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Answer_multi_choice
(
    `id`           INT             NOT NULL    AUTO_INCREMENT, 
    `question_id`  INT             NOT NULL, 
    `answer`       VARCHAR(255)    NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Answer_multi_choice
    ADD CONSTRAINT FK_Answer_multi_choice_question_id_multi_choice_id FOREIGN KEY (question_id)
        REFERENCES multi_choice (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Certificates_User
(
    `id`              INT         NOT NULL    AUTO_INCREMENT, 
    `certificate_id`  INT         NOT NULL, 
    `user_id`         INT         NOT NULL, 
    `date`            DATETIME    NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Certificates_User
    ADD CONSTRAINT FK_Certificates_User_certificate_id_Certificates_id FOREIGN KEY (certificate_id)
        REFERENCES Certificates (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Certificates_User
    ADD CONSTRAINT FK_Certificates_User_user_id_Users_id FOREIGN KEY (user_id)
        REFERENCES Users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE promotion_course
(
    `id`             INT       NOT NULL    AUTO_INCREMENT, 
    `promotion_id`   INT       NOT NULL, 
    `course_id`      INT       NOT NULL, 
    `updateDate`     DATE      NOT NULL, 
    `priceDiscount`  DOUBLE    NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE promotion_course
    ADD CONSTRAINT FK_promotion_course_promotion_id_promotion_id FOREIGN KEY (promotion_id)
        REFERENCES promotion (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE promotion_course
    ADD CONSTRAINT FK_promotion_course_course_id_Courses_id FOREIGN KEY (course_id)
        REFERENCES Courses (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE resultEssay
(
    `id`             INT             NOT NULL    AUTO_INCREMENT, 
    `score`          VARCHAR(255)    NULL, 
    `essay_id`       INT             NOT NULL, 
    `instructor_id`  INT             NOT NULL, 
    `user_id`        INT             NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE resultEssay
    ADD CONSTRAINT FK_resultEssay_essay_id_essay_id FOREIGN KEY (essay_id)
        REFERENCES essay (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE resultEssay
    ADD CONSTRAINT FK_resultEssay_instructor_id_Instructors_id FOREIGN KEY (instructor_id)
        REFERENCES Instructors (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE resultEssay
    ADD CONSTRAINT FK_resultEssay_user_id_Users_id FOREIGN KEY (user_id)
        REFERENCES Users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Lesson
(
    `id`          INT             NOT NULL    AUTO_INCREMENT, 
    `title`       VARCHAR(45)     NOT NULL, 
    `urlVid`      VARCHAR(45)     NULL, 
    `section_id`  INT             NOT NULL, 
    `urlImg`      VARCHAR(255)    NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Lesson
    ADD CONSTRAINT FK_Lesson_section_id_Section_id FOREIGN KEY (section_id)
        REFERENCES Section (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE result_Multichoice
(
    `id`              INT    NOT NULL    AUTO_INCREMENT, 
    `score`           INT    NULL, 
    `multichoice_id`  INT    NOT NULL, 
    `instructor_id`   INT    NOT NULL, 
    `user_id`         INT    NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE result_Multichoice
    ADD CONSTRAINT FK_result_Multichoice_instructor_id_Instructors_id FOREIGN KEY (instructor_id)
        REFERENCES Instructors (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE result_Multichoice
    ADD CONSTRAINT FK_result_Multichoice_user_id_Users_id FOREIGN KEY (user_id)
        REFERENCES Users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE result_Multichoice
    ADD CONSTRAINT FK_result_Multichoice_multichoice_id_multi_choice_id FOREIGN KEY (multichoice_id)
        REFERENCES multi_choice (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Roles Table Create SQL
CREATE TABLE Answer_essay
(
    `id`        INT             NOT NULL    AUTO_INCREMENT, 
    `answer`    VARCHAR(255)    NOT NULL, 
    `user_id`   INT             NOT NULL, 
    `essay_id`  INT             NOT NULL, 
    PRIMARY KEY (id)
);

ALTER TABLE Answer_essay
    ADD CONSTRAINT FK_Answer_essay_user_id_Users_id FOREIGN KEY (user_id)
        REFERENCES Users (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Answer_essay
    ADD CONSTRAINT FK_Answer_essay_essay_id_essay_id FOREIGN KEY (essay_id)
        REFERENCES essay (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


