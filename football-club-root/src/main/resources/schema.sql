CREATE TABLE event (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    display VARCHAR(255),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE event_match_day_rel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    event_id BIGINT NOT NULL,
    match_day_id BIGINT NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE match_day (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    display VARCHAR(255),
    plan_date DATETIME,
    actual_date DATETIME,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE game (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    match_day_id BIGINT NOT NULL,
    start_time DATETIME,
    end_time DATETIME,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE game_participants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE team (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    display VARCHAR(255),
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE team_player_rel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    start_date DATETIME,
    end_date DATETIME,
    is_current BIT(1) DEFAULT 0,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);

CREATE TABLE player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    gender BIT(1),
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_user VARCHAR(255),
    update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
    update_user VARCHAR(255)
);
