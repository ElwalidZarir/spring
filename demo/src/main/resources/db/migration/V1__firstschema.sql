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
