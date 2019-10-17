
-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1178120194015498240, '软件项目管理');
INSERT INTO `course` VALUES (1178120781289361408, '物流管理');
INSERT INTO `course` VALUES (1178120782501515264, '供应链管理');
INSERT INTO `course` VALUES (1178120782769950720, '电子商务案例分析');

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1182956441719562241, '18113447321582694865861588115009', '2019-10-12 17:49:28', 305.08, 'Absalom, Absalom! X 1', 'F');
INSERT INTO `order_info` VALUES (1182956738563035137, '72382298189612933358686097876704', '2019-10-12 17:50:39', 630.15, 'As I Lay Dying X 5', 'A');
INSERT INTO `order_info` VALUES (1182956971745456129, '79903345982220400353239764770037', '2019-10-12 17:51:32', 272.35, 'Precious Bane X 4', 'S');
INSERT INTO `order_info` VALUES (1182956978292670465, '32995664478498453850626050079810', '2019-10-12 17:51:34', 743.43, 'The Wives of Bath X 5', 'F');
INSERT INTO `order_info` VALUES (1182956978296860673, '60061294324969714141074531462451', '2019-10-12 17:51:34', 420.02, 'Françoise Sagan X 9', 'S');
INSERT INTO `order_info` VALUES (1182956979865567233, '94148549201396067169141872376585', '2019-10-12 17:51:35', 946.81, 'Antic Hay X 2', 'A');
INSERT INTO `order_info` VALUES (1182957031845576705, '46836566820779841418597882318456', '2019-10-12 17:51:49', 798.02, 'The House of Mirth X 2', 'A');
INSERT INTO `order_info` VALUES (1182957031883321345, '81991372771112912809849614677281', '2019-10-12 17:51:49', 276.83, 'Fame Is the Spur X 2', 'F');

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (6, '赵子骞', 24);
INSERT INTO `student` VALUES (7, '孟浩然', 24);
INSERT INTO `student` VALUES (8, '龚伟泽', 23);
INSERT INTO `student` VALUES (9, '江鹏涛', 22);
INSERT INTO `student` VALUES (10, '彭皓轩', 29);
INSERT INTO `student` VALUES (11, '邱鑫鹏', 20);
INSERT INTO `student` VALUES (12, '陈思聪', 22);
INSERT INTO `student` VALUES (13, '徐琪', 20);
INSERT INTO `student` VALUES (14, '戴建辉', 28);
INSERT INTO `student` VALUES (15, '朱楷瑞', 29);
INSERT INTO `student` VALUES (17, '陈乐驹', 19);
INSERT INTO `student` VALUES (100, 'T1', 1);

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1178113269612990465, '0765', '雷志泽');
INSERT INTO `teacher` VALUES (1178113341218181122, '2100', '卢振家');
INSERT INTO `teacher` VALUES (1178113368455909378, '6373', '覃梓晨');
INSERT INTO `teacher` VALUES (1182461707431542786, '2565', '罗天磊');
INSERT INTO `teacher` VALUES (1182461917599752194, '1529', '彭子默');
INSERT INTO `teacher` VALUES (1182461938944528386, '5370', '何建辉');
INSERT INTO `teacher` VALUES (1182461958557020162, '9386', '丁潇然');
INSERT INTO `teacher` VALUES (1182461976848433153, '1436', '段明哲');
INSERT INTO `teacher` VALUES (1182461985354424322, '5722', '邓烨华');
INSERT INTO `teacher` VALUES (1182461987204165633, '9207', '冯煜祺');
INSERT INTO `teacher` VALUES (1182461999828959233, '3541', '姜修杰');
INSERT INTO `teacher` VALUES (1182462007735255041, '2341', '杜乐驹');
INSERT INTO `teacher` VALUES (1182824532578443266, '1828', '姚远航');
INSERT INTO `teacher` VALUES (1182824673741963266, '3573', '夏锦程');
INSERT INTO `teacher` VALUES (1182825897396551681, '3239', '洪旭尧');
INSERT INTO `teacher` VALUES (1183931749432954880, 'c4np', '吴浩轩');

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, '姚智渊', 21, '92893775@qq.com', NULL, 1, '{\"city\":\"厦海市\",\"province\":\"广西省\"}', NULL, 0);
INSERT INTO `user` VALUES (5, '曹建辉', 43, '91379176@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (11, '邵金鑫', 28, '54020130@qq.com', NULL, 1, NULL, 2, 0);
INSERT INTO `user` VALUES (12, '严文博', 28, '22760935@qq.com', NULL, 1, NULL, 2, 0);
INSERT INTO `user` VALUES (16, '苏文博', 18, '22120964@qq.com', NULL, 1, NULL, 2, 1);
INSERT INTO `user` VALUES (17, '段绍齐', 43, '20620604@qq.com', NULL, 1, NULL, NULL, 0);
INSERT INTO `user` VALUES (20, '朱炫明', 74, '41836755@qq.com', 'U', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (21, '叶正豪', 29, '51178015@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (23, '侯钰轩', 53, '59403257@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (28, '曹彬', 93, '32705093@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (29, '姚浩宇', 70, '75398823@qq.com', NULL, 1, NULL, 1, 1);
INSERT INTO `user` VALUES (33, '傅志泽', 54, '14286729@qq.com', NULL, 1, NULL, NULL, 1);
INSERT INTO `user` VALUES (34, '赖明', 91, '86340826@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (37, '侯昊焱', 66, '75369134@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (38, '李烨磊', 19, '09297357@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (42, '郑建辉', 58, '85824548@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (46, '赖瑾瑜', 60, '20098049@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (47, '贾胤祥', 42, '56937352@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (49, '覃鹏飞', 97, '04306490@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (54, '薛航', 71, '52245248@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (58, '吕志强', 36, '05882136@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (59, '万天翊', 51, '39957264@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (61, '钟思远', 53, '20112990@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (62, '杨浩', 56, '38731677@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (65, '邓绍齐', 63, '15961102@qq.com', 'U', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (67, '姚明', 100, '79301326@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (69, '郭展鹏', 17, '28241617@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (70, '孔子轩', 90, '42535937@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (73, '尹涛', 93, '08328700@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (75, '金伟宸', 98, '75227213@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (78, '董天翊', 54, '99901995@qq.com', 'U', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (80, '顾昊强', 70, '94332682@qq.com', 'U', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (82, '金伟泽', 14, '89400590@qq.com', 'F', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (83, '陶绍齐', 68, '78686577@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (86, '莫振家', 45, '00866606@qq.com', 'U', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (88, '崔子默', 25, '88777800@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (94, '雷鹏煊', 41, '72213835@qq.com', 'U', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (98, '何博涛', 6, '51784499@qq.com', 'M', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (100, '范伟诚', 38, '63760355@qq.com', 'F', NULL, NULL, NULL, 0);


