-- 创建gender enum
-- create type gender as enum ('MALE', 'FEMALE');

-- 修改student中的gender类型为enum
alter table student alter column gender type gender using (gender::gender);