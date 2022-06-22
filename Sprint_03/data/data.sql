INSERT INTO `criminal`.`tbl_detective` (`id`, `created_at`, `modified_at`, `version`, `armed`, `badgeNumber`, `firstName`, `hiringDate`, `lastName`, `password`, `rank_detective`, `status_detective`, `username`) VALUES ('1', '2003-03-24 17:23:34', '2003-03-24 17:23:34', '1', true, '512334', 'Nguyễn Văn', '2003-03-24 17:23:34', 'Kiên', '123123', 'TRAINEE', 'ACTIVE', 'nguyenkien123');
INSERT INTO `criminal`.`tbl_detective` (`id`, `created_at`, `modified_at`, `version`, `armed`, `badgeNumber`, `firstName`, `hiringDate`, `lastName`, `password`, `rank_detective`, `status_detective`, `username`) VALUES ('2', '2003-03-24 17:23:34', '2003-03-24 17:23:34', '1', true, '451727', 'Nguyễn Anh', '2003-03-24 17:23:34', 'Quân', '123123', 'TRAINEE', 'ACTIVE', 'anhquan9x');
INSERT INTO `criminal`.`tbl_detective` (`id`, `created_at`, `modified_at`, `version`, `armed`, `badgeNumber`, `firstName`, `hiringDate`, `lastName`, `password`, `rank_detective`, `status_detective`, `username`) VALUES ('3', '2003-03-24 17:23:34', '2003-03-24 17:23:34', '1', true, '214214', 'Hải', '2003-03-24 17:23:34', 'Nam', '123', 'SUSPENDED', 'ACTIVE', 'hainam58');
INSERT INTO `criminal`.`tbl_detective` (`id`, `created_at`, `modified_at`, `version`, `armed`, `badgeNumber`, `firstName`, `hiringDate`, `lastName`, `password`, `rank_detective`, `status_detective`, `username`) VALUES ('4', '2003-03-24 17:23:34', '2003-03-24 17:23:34', '1', true, '312512', 'Đăng', '2003-03-24 17:23:34', 'Dũng', '123', 'VACATION', 'ACTIVE', 'dangdung147');
INSERT INTO `criminal`.`tbl_detective` (`id`, `created_at`, `modified_at`, `version`, `armed`, `badgeNumber`, `firstName`, `hiringDate`, `lastName`, `password`, `rank_detective`, `status_detective`, `username`) VALUES ('5', '2003-03-24 17:23:34', '2003-03-24 17:23:34', '1', true, '543123', 'Phạm Huy', '2003-03-24 17:23:34', 'Anh', '123123', 'UNDER_INVESTIGATION', 'ACTIVE', 'huyanh');
INSERT INTO `criminal`.`tbl_detective` (`id`, `created_at`, `modified_at`, `version`, `armed`, `badgeNumber`, `firstName`, `hiringDate`, `lastName`, `password`, `rank_detective`, `status_detective`, `username`) VALUES ('6', '2003-03-24 17:23:34', '2003-03-24 17:23:34', '1', true, '563467', 'Trung', '2003-03-24 17:23:34', 'Dũng', '123', 'RETIRED', 'ACTIVE', 'trungdung92');


INSERT INTO `criminal`.`tbl_criminal` (`id`, `created_at`, `modified_at`, `version`, `detailedDescription`, `notes`, `number`, `shortDescription`, `status`, `type`, `lead_investigator`) VALUES ('1', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'criminal case 1', 'notes 1', '5234321', 'criminal case 1', 'UNDER_INVESTIGATION', 'UNCATEGORIZED', '1');
INSERT INTO `criminal`.`tbl_criminal` (`id`, `created_at`, `modified_at`, `version`, `detailedDescription`, `notes`, `number`, `shortDescription`, `status`, `type`, `lead_investigator`) VALUES ('2', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'criminal case 2', 'notes 2', '4124125', 'criminal case 2', 'UNDER_INVESTIGATION', 'UNCATEGORIZED', '4');



INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('2', '1');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('3', '1');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('4', '1');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('5', '1');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('6', '1');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('1', '2');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('2', '2');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('3', '2');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('5', '2');
INSERT INTO `criminal`.`tbl_criminal_detective` (`detective_id`, `criminal_case_id`) VALUES ('6', '2');



INSERT INTO `criminal`.`tbl_storage` (`id`, `created_at`, `modified_at`, `version`, `location`, `name`) VALUES ('1', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'location 1', 'name 1');
INSERT INTO `criminal`.`tbl_storage` (`id`, `created_at`, `modified_at`, `version`, `location`, `name`) VALUES ('2', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'location 2', 'name 2');
INSERT INTO `criminal`.`tbl_storage` (`id`, `created_at`, `modified_at`, `version`, `location`, `name`) VALUES ('3', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'location 3', 'name 3');
INSERT INTO `criminal`.`tbl_storage` (`id`, `created_at`, `modified_at`, `version`, `location`, `name`) VALUES ('4', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '2', 'location 4', 'name 4');


INSERT INTO `criminal`.`tbl_evidence` (`id`, `created_at`, `modified_at`, `version`, `archived`, `itemName`, `notes`, `number`, `criminal_case_id`, `storage_id`) VALUES ('1', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', true, 'itemName 1', 'notes 1', '523423', '1', '1');
INSERT INTO `criminal`.`tbl_evidence` (`id`, `created_at`, `modified_at`, `version`, `archived`, `itemName`, `notes`, `number`, `criminal_case_id`, `storage_id`) VALUES ('2', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', true, 'itemName 2', 'notes 2', '125123', '1', '1');
INSERT INTO `criminal`.`tbl_evidence` (`id`, `created_at`, `modified_at`, `version`, `archived`, `itemName`, `notes`, `number`, `criminal_case_id`, `storage_id`) VALUES ('3', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', true, 'itemName 3', 'notes 3', '621341', '2', '2');
INSERT INTO `criminal`.`tbl_evidence` (`id`, `created_at`, `modified_at`, `version`, `archived`, `itemName`, `notes`, `number`, `criminal_case_id`, `storage_id`) VALUES ('4', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', true, 'itemName 4', 'notes 4', '912367', '2', '3');
INSERT INTO `criminal`.`tbl_evidence` (`id`, `created_at`, `modified_at`, `version`, `archived`, `itemName`, `notes`, `number`, `criminal_case_id`, `storage_id`) VALUES ('5', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', true, 'itemName 5', 'notes 5', '812367', '2', '4');



INSERT INTO `criminal`.`tbl_trackentry` (`id`, `created_at`, `modified_at`, `version`, `action`, `date`, `resson`, `detective_id`, `evidence_id`) VALUES ('1', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'RETRIEVED', '2003-03-24 17:23:34.000000', 'resson 1', '1', '1');
INSERT INTO `criminal`.`tbl_trackentry` (`id`, `created_at`, `modified_at`, `version`, `action`, `date`, `resson`, `detective_id`, `evidence_id`) VALUES ('2', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'RETRIEVED', '2003-03-24 17:23:34.000000', 'resson 2', '2', '1');
INSERT INTO `criminal`.`tbl_trackentry` (`id`, `created_at`, `modified_at`, `version`, `action`, `date`, `resson`, `detective_id`, `evidence_id`) VALUES ('3', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'RETRIEVED', '2003-03-24 17:23:34.000000', 'resson 3', '3', '1');
INSERT INTO `criminal`.`tbl_trackentry` (`id`, `created_at`, `modified_at`, `version`, `action`, `date`, `resson`, `detective_id`, `evidence_id`) VALUES ('4', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'RETRIEVED', '2003-03-24 17:23:34.000000', 'resson 4', '5', '2');
INSERT INTO `criminal`.`tbl_trackentry` (`id`, `created_at`, `modified_at`, `version`, `action`, `date`, `resson`, `detective_id`, `evidence_id`) VALUES ('5', '2003-03-24 17:23:34.000000', '2003-03-24 17:23:34.000000', '1', 'RETRIEVED', '2003-03-24 17:23:34.000000', 'resson 5', '1', '2');
