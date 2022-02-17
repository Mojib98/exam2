Create table if not exists Account(
    id SERIAL,
    userid integer primary key ,
    username varchar(20) unique ,
    passcode integer,
    datea date
);
CREATE table if not exists tweet(
    id serial primary key ,
    username varchar(20),
    userid integer references Account(userid),
    datet date,
    tweet varchar(280),
    idtweet integer unique
);
CREATE table if not exists comment(
    id serial,
    iduser integer references Account(userid),
    username varchar(20) ,
    date1 date,
    comment varchar(100),
    idtweet integer references tweet(id),
    idcomment integer
)
