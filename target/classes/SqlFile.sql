Create table if not exists Account(
    id SERIAL,
    userid integer primary key ,
    username varchar(20) unique ,
    passcode integer,
    datea date
);
CREATE table if not exists tweet(
    id serial,
    userid integer references Account(userid),
    datet date,
    tweet varchar(280),
    idtweet integer
)