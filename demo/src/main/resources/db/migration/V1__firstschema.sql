CREATE TABLE profile (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bio TEXT
);

CREATE TABLE skill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE experience (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_title VARCHAR(255) NOT NULL,
    profile_id INT,
    CONSTRAINT fk_experience_profile FOREIGN KEY (profile_id) REFERENCES profile(id)
);

CREATE TABLE experience_skills (
    experience_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (experience_id, skill_id),
    FOREIGN KEY (experience_id) REFERENCES experience(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);

CREATE TABLE user(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);


CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text TEXT,
    likes INT,
    profile_id INT,
    CONSTRAINT fk_post_profile FOREIGN KEY (profile_id) REFERENCES profile(id)
);

CREATE TABLE `group` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE group_profile (
    group_id INT NOT NULL,
    profile_id INT NOT NULL,
    PRIMARY KEY (group_id, profile_id),
    CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES `group`(id),
    CONSTRAINT fk_profile_id FOREIGN KEY (profile_id) REFERENCES profile(id)
);
