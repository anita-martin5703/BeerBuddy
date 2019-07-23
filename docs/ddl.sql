CREATE TABLE IF NOT EXISTS `Bar`
(
    `id`             INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `bar_id`         INTEGER                           NOT NULL,
    `name`           TEXT                              NOT NULL,
    `type`           TEXT,
    `projected_date` TEXT
);

CREATE  INDEX `index_Bar_bar_id` ON `Bar` (`bar_id`);

CREATE  INDEX `index_Bar_projected_date` ON `Bar` (`projected_date`);

CREATE TABLE IF NOT EXISTS `Beer`
(
    `id`            INTEGER PRIMARY KEY AUTOINCREMENT,
    `beer_id`       INTEGER,
     `name`         TEXT,
    `brewery_house` TEXT,
    `beer_Abv`      INTEGER NOT NULL,
    `description`   TEXT,
    `style`         TEXT
);

CREATE UNIQUE INDEX `index_Beer_name` ON `Beer` (`name`);

CREATE  INDEX `index_Beer_beer_id` ON `Beer` (`beer_id`);

CREATE  INDEX `index_Beer_brewery_house` ON `Beer` (`brewery_house`);

CREATE  INDEX `index_Beer_beer_Abv` ON `Beer` (`beer_Abv`);

CREATE TABLE IF NOT EXISTS `BarBeerJoin`
(
`beer_id`           INTEGER NOT NULL,
`bar_id`            INTEGER NOT NULL,
PRIMARY KEY         (`beer_id`, `bar_id`),
FOREIGN KEY         (`beer_id`)
REFERENCES          `Beer`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
FOREIGN KEY         (`bar_id`) REFERENCES `Bar`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE  INDEX `index_BarBeerJoin_beer_id` ON `BarBeerJoin` (`beer_id`);

CREATE  INDEX `index_BarBeerJoin_bar_id` ON `BarBeerJoin` (`bar_id`);