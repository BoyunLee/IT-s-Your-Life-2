create database world2;
use world2;

CREATE TABLE `country` (
                           `Code` char(3) NOT NULL DEFAULT '',
                           `Name` char(52) NOT NULL DEFAULT '',
                           `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')
                               NOT NULL DEFAULT 'Asia',
                           `Region` char(26) NOT NULL DEFAULT '',
                           `SurfaceArea` decimal(10,2) NOT NULL DEFAULT '0.00',
                           `IndepYear` smallint DEFAULT NULL,
                           `Population` int NOT NULL DEFAULT '0',
                           `LifeExpectancy` decimal(3,1) DEFAULT NULL,
                           `GNP` decimal(10,2) DEFAULT NULL,
                           `GNPOld` decimal(10,2) DEFAULT NULL,
                           `LocalName` char(45) NOT NULL DEFAULT '',
                           `GovernmentForm` char(45) NOT NULL DEFAULT '',
                           `HeadOfState` char(60) DEFAULT NULL,
                           `Capital` int DEFAULT NULL,
                           `Code2` char(2) NOT NULL DEFAULT '',
                           PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `countrylanguage` (
                                   `CountryCode` char(3) NOT NULL DEFAULT '',
                                   `Language` char(30) NOT NULL DEFAULT '',
                                   `IsOfficial` enum('T','F') NOT NULL DEFAULT 'F',
                                   `Percentage` decimal(4,1) NOT NULL DEFAULT '0.0',
                                   PRIMARY KEY (`CountryCode`,`Language`),
                                   KEY `CountryCode` (`CountryCode`),
                                   CONSTRAINT `countryLanguage_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `city` (
                        `ID` int NOT NULL AUTO_INCREMENT,
                        `Name` char(35) NOT NULL DEFAULT '',
                        `CountryCode` char(3) NOT NULL DEFAULT '',
                        `District` char(20) NOT NULL DEFAULT '',
                        `Population` int NOT NULL DEFAULT '0',
                        PRIMARY KEY (`ID`),
                        KEY `CountryCode` (`CountryCode`),
                        CONSTRAINT `city_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=4080 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `country`
(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2)
VALUES
    ('TKM', 'Turkmenistan', 'Asia', 'Southern and Central Asia', 488100.00, 1991, 4459000, 60.9, 4397.00, 2000.00, 'Türkmenostan', 'Republic', 'Saparmurat Niyazov', 3419, 'TM'),
    ('TUV', 'Tuvalu', 'Oceania', 'Polynesia', 26.00, NULL, 12000, 66.3, 6.00, NULL, 'Tuvalu', 'Constitutional Monarchy', 'Elisabeth II', 3424, 'TV'),
    ('PNG', 'Papua New Guinea', 'Oceania', 'Melanesia', 462840.00, 1975, 4807000, 63.1, 4988.00, NULL, 'Papua Niu Gini', 'Constitutional Monarchy', 'Elisabeth II', 2884, 'PG'),
    ('TZA', 'Tanzania', 'Africa', 'Eastern Africa', 883749.00, 1961, 33517000, 52.3, 8005.00, 7388.00, 'Tanzania', 'Republic', 'Benjamin William Mkapa', 3306, 'TZ'),
    ('NPL', 'Nepal', 'Asia', 'Southern and Central Asia', 147181.00, 1769, 23930000, 57.8, 4768.00, 4837.00, 'Nepal', 'Constitutional Monarchy', 'Gyanendra Bir Bikram', 2729, 'NP'),
    ('CHE', 'Switzerland', 'Europe', 'Western Europe', 41284.00, NULL, 7160400, 79.6, 264478.00, 256092.00, 'Schweiz/Suisse/Svizzera/Svizra', 'Federation', 'Adolf Ogi', 3248, 'CH'),
    ('EGY', 'Egypt', 'Africa', 'Northern Africa', 1001449.00, 1922, 68470000, 63.3, 82710.00, 75617.00, 'Misr', 'Republic', 'Hosni Mubarak', 608, 'EG'),
    ('GMB', 'Gambia', 'Africa', 'Western Africa', 11295.00, 1965, 1305000, 53.2, 320.00, 325.00, 'The Gambia', 'Republic', 'Yahya Jammeh', 904, 'GM'),
    ('OMN', 'Oman', 'Asia', 'Middle East', 309500.00, 1951, 2542000, 71.8, 16904.00, 16153.00, '´Uman', 'Monarchy (Sultanate)', 'Qabus ibn Sa´id', 2821, 'OM'),
    ('MDG', 'Madagascar', 'Africa', 'Eastern Africa', 587041.00, 1960, 15942000, 55.0, 3750.00, 3545.00, 'Madagasikara/Madagascar', 'Federal Republic', 'Didier Ratsiraka', 2455, 'MG');


INSERT INTO `countrylanguage` (CountryCode, Language, IsOfficial, Percentage) VALUES
      ('TKM', 'Turkmen', 'T', 85.0),
      ('TUV', 'Tuvaluan', 'T', 96.5),
      ('PNG', 'Hiri Motu', 'F', 15.0),
      ('TZA', 'Swahili', 'T', 90.0),
      ('NPL', 'Nepali', 'T', 80.0),
      ('CHE', 'German', 'T', 65.0),
      ('CHE', 'French', 'F', 22.5),
      ('EGY', 'Arabic', 'T', 99.0),
      ('GMB', 'English', 'F', 20.0),
      ('OMN', 'Arabic', 'T', 75.0),
      ('MDG', 'Malagasy', 'T', 85.0);

INSERT INTO `city` (Name, CountryCode, District, Population) VALUES
     ('Ashgabat', 'TKM', 'Ahal', 1000000),
     ('Funafuti', 'TUV', 'Funafuti', 6000),
     ('Port Moresby', 'PNG', 'National Capital', 364125),
     ('Dar es Salaam', 'TZA', 'Dar es Salaam', 4364541),
     ('Kathmandu', 'NPL', 'Bagmati', 1000000),
     ('Zurich', 'CHE', 'Zurich', 402762),
     ('Geneva', 'CHE', 'Geneva', 201818),
     ('Cairo', 'EGY', 'Cairo', 9900000),
     ('Banjul', 'GMB', 'Banjul', 35701),
     ('Muscat', 'OMN', 'Muscat', 797000),
     ('Antananarivo', 'MDG', 'Analamanga', 1391433);
