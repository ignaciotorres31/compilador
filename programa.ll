;Programa: Prueba
source_filename = "Prueba.txt"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.16.27038"

declare i32 @printf(i8*, ...)
declare i32 @puts(i8*)
declare i32 @scanf(i8* %0, ...)

@.integer = private constant [4 x i8] c"%d\0A\00"
@.float = private constant [5 x i8] c"%lf\0A\00"
@.int_read_format = unnamed_addr constant [3 x i8] c"%d\00"
@.double_read_format = unnamed_addr constant [4 x i8]  c"%lf\00"


@str1 = private constant [20 x i8] c"La lista esta vacia\00"
@str2 = private constant [22 x i8] c"El valor debe ser >=1\00"
@str3 = private constant [47 x i8] c"La lista tiene menos elementos que el indicado\00"
@str4 = private constant [57 x i8] c"No existen suficientes elementos impares para el calculo\00"
@str5 = private constant [20 x i8] c"La lista esta vacia\00"
@str6 = private constant [22 x i8] c"El valor debe ser >=1\00"
@str7 = private constant [47 x i8] c"La lista tiene menos elementos que el indicado\00"
@str8 = private constant [57 x i8] c"No existen suficientes elementos impares para el calculo\00"
@_aux1 = global i32 0
@_aux2 = global i32 0
@b1 = global i1 0
@b2 = global i1 0
@num1 = global i32 0
@_suma1 = global i32 0
@_suma2 = global i32 0
@f1 = global double 0.0
@_temp1 = global i32 0
@f2 = global double 0.0
@_temp2 = global i32 0
@a1 = global i32 0
@a2 = global i32 0


define i32 @main(i32, i8**) {
	%var12 = add i32 0, 0
	store i32 %var12, i32* @_suma2
	%var14 = add i32 0, 1
	store i32 %var14, i32* @_aux2
	%var17 = add i32 0, 5
	%var19 = add i32 0, 0
	%var18 = icmp eq i32  %var17, %var19
	br i1 %var18, label %etthen16, label %etelse16
	etthen16:
	%dest21 = call i32 @puts(i8* getelementptr ([20 x i8], [20 x i8] * @str5, i32 0, i32 0))
	br label %etfinif16
	etelse16:
	%var24 = add i32 0, 3
	%var26 = add i32 0, 0
	%var25 = icmp sle i32  %var24, %var26
	br i1 %var25, label %etthen23, label %etelse23
	etthen23:
	%dest28 = call i32 @puts(i8* getelementptr ([22 x i8], [22 x i8] * @str6, i32 0, i32 0))
	br label %etfinif23
	etelse23:
	%var31 = add i32 0, 3
	%var33 = add i32 0, 5
	%var32 = icmp sgt i32  %var31, %var33
	br i1 %var32, label %etthen30, label %etelse30
	etthen30:
	%dest35 = call i32 @puts(i8* getelementptr ([47 x i8], [47 x i8] * @str7, i32 0, i32 0))
	br label %etfinif30
	etelse30:
	%var38 = load i32, i32* @_aux2
	%var40 = add i32 0, 3
	%var39 = icmp sle i32  %var38, %var40
	br i1 %var39, label %etthen37, label %etfinif37
	etthen37:
	%var42 = add i32 0, 1
	store i32 %var42, i32* @_temp2
	br label %etwhile44
	etwhile44:
	%var45 = load i32, i32* @_temp2
	%var47 = add i32 0, 1
	%var46 = icmp sgt i32  %var45, %var47
	br i1 %var46, label %etwhiletrue44, label %etfinwhile44
	etwhiletrue44:
	%var49 = load i32, i32* @_temp2
	%var51 = add i32 0, 2
	%var50 = sub i32 %var49, %var51
	store i32 %var50, i32* @_temp2
	br label %etwhile44
	etfinwhile44:
	%var54 = load i32, i32* @_temp2
	%var56 = add i32 0, 1
	%var55 = icmp eq i32  %var54, %var56
	br i1 %var55, label %etthen53, label %etfinif53
	etthen53:
	%var58 = load i32, i32* @_suma2
	%var60 = add i32 0, 1
	%var59 = add i32 %var58, %var60
	store i32 %var59, i32* @_suma2
	%var62 = load i32, i32* @_aux2
	%var64 = add i32 0, 1
	%var63 = add i32 %var62, %var64
	store i32 %var63, i32* @_aux2
	br label %etfinif53
	etfinif53:
	br label %etfinif37
	etfinif37:
	%var67 = load i32, i32* @_aux2
	%var69 = add i32 0, 3
	%var68 = icmp sle i32  %var67, %var69
	br i1 %var68, label %etthen66, label %etfinif66
	etthen66:
	%var71 = add i32 0, 2
	store i32 %var71, i32* @_temp2
	br label %etwhile73
	etwhile73:
	%var74 = load i32, i32* @_temp2
	%var76 = add i32 0, 1
	%var75 = icmp sgt i32  %var74, %var76
	br i1 %var75, label %etwhiletrue73, label %etfinwhile73
	etwhiletrue73:
	%var78 = load i32, i32* @_temp2
	%var80 = add i32 0, 2
	%var79 = sub i32 %var78, %var80
	store i32 %var79, i32* @_temp2
	br label %etwhile73
	etfinwhile73:
	%var83 = load i32, i32* @_temp2
	%var85 = add i32 0, 1
	%var84 = icmp eq i32  %var83, %var85
	br i1 %var84, label %etthen82, label %etfinif82
	etthen82:
	%var87 = load i32, i32* @_suma2
	%var89 = add i32 0, 2
	%var88 = add i32 %var87, %var89
	store i32 %var88, i32* @_suma2
	%var91 = load i32, i32* @_aux2
	%var93 = add i32 0, 1
	%var92 = add i32 %var91, %var93
	store i32 %var92, i32* @_aux2
	br label %etfinif82
	etfinif82:
	br label %etfinif66
	etfinif66:
	%var96 = load i32, i32* @_aux2
	%var98 = add i32 0, 3
	%var97 = icmp sle i32  %var96, %var98
	br i1 %var97, label %etthen95, label %etfinif95
	etthen95:
	%var100 = add i32 0, 3
	store i32 %var100, i32* @_temp2
	br label %etwhile102
	etwhile102:
	%var103 = load i32, i32* @_temp2
	%var105 = add i32 0, 1
	%var104 = icmp sgt i32  %var103, %var105
	br i1 %var104, label %etwhiletrue102, label %etfinwhile102
	etwhiletrue102:
	%var107 = load i32, i32* @_temp2
	%var109 = add i32 0, 2
	%var108 = sub i32 %var107, %var109
	store i32 %var108, i32* @_temp2
	br label %etwhile102
	etfinwhile102:
	%var112 = load i32, i32* @_temp2
	%var114 = add i32 0, 1
	%var113 = icmp eq i32  %var112, %var114
	br i1 %var113, label %etthen111, label %etfinif111
	etthen111:
	%var116 = load i32, i32* @_suma2
	%var118 = add i32 0, 3
	%var117 = add i32 %var116, %var118
	store i32 %var117, i32* @_suma2
	%var120 = load i32, i32* @_aux2
	%var122 = add i32 0, 1
	%var121 = add i32 %var120, %var122
	store i32 %var121, i32* @_aux2
	br label %etfinif111
	etfinif111:
	br label %etfinif95
	etfinif95:
	%var125 = load i32, i32* @_aux2
	%var127 = add i32 0, 3
	%var126 = icmp sle i32  %var125, %var127
	br i1 %var126, label %etthen124, label %etfinif124
	etthen124:
	%var130 = add i32 0, 0
	store i32 %var130, i32* @_suma1
	%var132 = add i32 0, 1
	store i32 %var132, i32* @_aux1
	%var135 = add i32 0, 3
	%var137 = add i32 0, 0
	%var136 = icmp eq i32  %var135, %var137
	br i1 %var136, label %etthen134, label %etelse134
	etthen134:
	%dest139 = call i32 @puts(i8* getelementptr ([20 x i8], [20 x i8] * @str1, i32 0, i32 0))
	br label %etfinif134
	etelse134:
	%var142 = add i32 0, 3
	%var144 = add i32 0, 0
	%var143 = icmp sle i32  %var142, %var144
	br i1 %var143, label %etthen141, label %etelse141
	etthen141:
	%dest146 = call i32 @puts(i8* getelementptr ([22 x i8], [22 x i8] * @str2, i32 0, i32 0))
	br label %etfinif141
	etelse141:
	%var149 = add i32 0, 3
	%var151 = add i32 0, 3
	%var150 = icmp sgt i32  %var149, %var151
	br i1 %var150, label %etthen148, label %etelse148
	etthen148:
	%dest153 = call i32 @puts(i8* getelementptr ([47 x i8], [47 x i8] * @str3, i32 0, i32 0))
	br label %etfinif148
	etelse148:
	%var156 = load i32, i32* @_aux1
	%var158 = add i32 0, 3
	%var157 = icmp sle i32  %var156, %var158
	br i1 %var157, label %etthen155, label %etfinif155
	etthen155:
	%var160 = add i32 0, 5
	store i32 %var160, i32* @_temp1
	br label %etwhile162
	etwhile162:
	%var163 = load i32, i32* @_temp1
	%var165 = add i32 0, 1
	%var164 = icmp sgt i32  %var163, %var165
	br i1 %var164, label %etwhiletrue162, label %etfinwhile162
	etwhiletrue162:
	%var167 = load i32, i32* @_temp1
	%var169 = add i32 0, 2
	%var168 = sub i32 %var167, %var169
	store i32 %var168, i32* @_temp1
	br label %etwhile162
	etfinwhile162:
	%var172 = load i32, i32* @_temp1
	%var174 = add i32 0, 1
	%var173 = icmp eq i32  %var172, %var174
	br i1 %var173, label %etthen171, label %etfinif171
	etthen171:
	%var176 = load i32, i32* @_suma1
	%var178 = add i32 0, 5
	%var177 = add i32 %var176, %var178
	store i32 %var177, i32* @_suma1
	%var180 = load i32, i32* @_aux1
	%var182 = add i32 0, 1
	%var181 = add i32 %var180, %var182
	store i32 %var181, i32* @_aux1
	br label %etfinif171
	etfinif171:
	br label %etfinif155
	etfinif155:
	%var185 = load i32, i32* @_aux1
	%var187 = add i32 0, 3
	%var186 = icmp sle i32  %var185, %var187
	br i1 %var186, label %etthen184, label %etfinif184
	etthen184:
	%var189 = add i32 0, 7
	store i32 %var189, i32* @_temp1
	br label %etwhile191
	etwhile191:
	%var192 = load i32, i32* @_temp1
	%var194 = add i32 0, 1
	%var193 = icmp sgt i32  %var192, %var194
	br i1 %var193, label %etwhiletrue191, label %etfinwhile191
	etwhiletrue191:
	%var196 = load i32, i32* @_temp1
	%var198 = add i32 0, 2
	%var197 = sub i32 %var196, %var198
	store i32 %var197, i32* @_temp1
	br label %etwhile191
	etfinwhile191:
	%var201 = load i32, i32* @_temp1
	%var203 = add i32 0, 1
	%var202 = icmp eq i32  %var201, %var203
	br i1 %var202, label %etthen200, label %etfinif200
	etthen200:
	%var205 = load i32, i32* @_suma1
	%var207 = add i32 0, 7
	%var206 = add i32 %var205, %var207
	store i32 %var206, i32* @_suma1
	%var209 = load i32, i32* @_aux1
	%var211 = add i32 0, 1
	%var210 = add i32 %var209, %var211
	store i32 %var210, i32* @_aux1
	br label %etfinif200
	etfinif200:
	br label %etfinif184
	etfinif184:
	%var214 = load i32, i32* @_aux1
	%var216 = add i32 0, 3
	%var215 = icmp sle i32  %var214, %var216
	br i1 %var215, label %etthen213, label %etfinif213
	etthen213:
	%var218 = add i32 0, 9
	store i32 %var218, i32* @_temp1
	br label %etwhile220
	etwhile220:
	%var221 = load i32, i32* @_temp1
	%var223 = add i32 0, 1
	%var222 = icmp sgt i32  %var221, %var223
	br i1 %var222, label %etwhiletrue220, label %etfinwhile220
	etwhiletrue220:
	%var225 = load i32, i32* @_temp1
	%var227 = add i32 0, 2
	%var226 = sub i32 %var225, %var227
	store i32 %var226, i32* @_temp1
	br label %etwhile220
	etfinwhile220:
	%var230 = load i32, i32* @_temp1
	%var232 = add i32 0, 1
	%var231 = icmp eq i32  %var230, %var232
	br i1 %var231, label %etthen229, label %etfinif229
	etthen229:
	%var234 = load i32, i32* @_suma1
	%var236 = add i32 0, 9
	%var235 = add i32 %var234, %var236
	store i32 %var235, i32* @_suma1
	%var238 = load i32, i32* @_aux1
	%var240 = add i32 0, 1
	%var239 = add i32 %var238, %var240
	store i32 %var239, i32* @_aux1
	br label %etfinif229
	etfinif229:
	br label %etfinif213
	etfinif213:
	%var243 = load i32, i32* @_aux1
	%var245 = add i32 0, 3
	%var244 = icmp slt i32  %var243, %var245
	br i1 %var244, label %etthen242, label %etfinif242
	etthen242:
	%dest247 = call i32 @puts(i8* getelementptr ([57 x i8], [57 x i8] * @str4, i32 0, i32 0))
	%var248 = add i32 0, 0
	store i32 %var248, i32* @_suma1
	br label %etfinif242
	etfinif242:
	br label %etfinif148
	etfinif148:
	br label %etfinif141
	etfinif141:
	br label %etfinif134
	etfinif134:
	%var129 = load i32, i32* @_suma1
	store i32 %var129, i32* @_temp2
	br label %etwhile251
	etwhile251:
	%var252 = load i32, i32* @_temp2
	%var254 = add i32 0, 1
	%var253 = icmp sgt i32  %var252, %var254
	br i1 %var253, label %etwhiletrue251, label %etfinwhile251
	etwhiletrue251:
	%var256 = load i32, i32* @_temp2
	%var258 = add i32 0, 2
	%var257 = sub i32 %var256, %var258
	store i32 %var257, i32* @_temp2
	br label %etwhile251
	etfinwhile251:
	%var261 = load i32, i32* @_temp2
	%var263 = add i32 0, 1
	%var262 = icmp eq i32  %var261, %var263
	br i1 %var262, label %etthen260, label %etfinif260
	etthen260:
	%var265 = load i32, i32* @_suma2
	%var268 = add i32 0, 0
	store i32 %var268, i32* @_suma1
	%var270 = add i32 0, 1
	store i32 %var270, i32* @_aux1
	%var273 = add i32 0, 3
	%var275 = add i32 0, 0
	%var274 = icmp eq i32  %var273, %var275
	br i1 %var274, label %etthen272, label %etelse272
	etthen272:
	%dest277 = call i32 @puts(i8* getelementptr ([20 x i8], [20 x i8] * @strnull, i32 0, i32 0))
	br label %etfinif272
	etelse272:
	%var280 = add i32 0, 3
	%var282 = add i32 0, 0
	%var281 = icmp sle i32  %var280, %var282
	br i1 %var281, label %etthen279, label %etelse279
	etthen279:
	%dest284 = call i32 @puts(i8* getelementptr ([22 x i8], [22 x i8] * @strnull, i32 0, i32 0))
	br label %etfinif279
	etelse279:
	%var287 = add i32 0, 3
	%var289 = add i32 0, 3
	%var288 = icmp sgt i32  %var287, %var289
	br i1 %var288, label %etthen286, label %etelse286
	etthen286:
	%dest291 = call i32 @puts(i8* getelementptr ([47 x i8], [47 x i8] * @strnull, i32 0, i32 0))
	br label %etfinif286
	etelse286:
	%var294 = load i32, i32* @_aux1
	%var296 = add i32 0, 3
	%var295 = icmp sle i32  %var294, %var296
	br i1 %var295, label %etthen293, label %etfinif293
	etthen293:
	%var298 = add i32 0, 5
	store i32 %var298, i32* @_temp1
	br label %etwhile300
	etwhile300:
	%var301 = load i32, i32* @_temp1
	%var303 = add i32 0, 1
	%var302 = icmp sgt i32  %var301, %var303
	br i1 %var302, label %etwhiletrue300, label %etfinwhile300
	etwhiletrue300:
	%var305 = load i32, i32* @_temp1
	%var307 = add i32 0, 2
	%var306 = sub i32 %var305, %var307
	store i32 %var306, i32* @_temp1
	br label %etwhile300
	etfinwhile300:
	%var310 = load i32, i32* @_temp1
	%var312 = add i32 0, 1
	%var311 = icmp eq i32  %var310, %var312
	br i1 %var311, label %etthen309, label %etfinif309
	etthen309:
	%var314 = load i32, i32* @_suma1
	%var316 = add i32 0, 5
	%var315 = add i32 %var314, %var316
	store i32 %var315, i32* @_suma1
	%var318 = load i32, i32* @_aux1
	%var320 = add i32 0, 1
	%var319 = add i32 %var318, %var320
	store i32 %var319, i32* @_aux1
	br label %etfinif309
	etfinif309:
	br label %etfinif293
	etfinif293:
	%var323 = load i32, i32* @_aux1
	%var325 = add i32 0, 3
	%var324 = icmp sle i32  %var323, %var325
	br i1 %var324, label %etthen322, label %etfinif322
	etthen322:
	%var327 = add i32 0, 7
	store i32 %var327, i32* @_temp1
	br label %etwhile329
	etwhile329:
	%var330 = load i32, i32* @_temp1
	%var332 = add i32 0, 1
	%var331 = icmp sgt i32  %var330, %var332
	br i1 %var331, label %etwhiletrue329, label %etfinwhile329
	etwhiletrue329:
	%var334 = load i32, i32* @_temp1
	%var336 = add i32 0, 2
	%var335 = sub i32 %var334, %var336
	store i32 %var335, i32* @_temp1
	br label %etwhile329
	etfinwhile329:
	%var339 = load i32, i32* @_temp1
	%var341 = add i32 0, 1
	%var340 = icmp eq i32  %var339, %var341
	br i1 %var340, label %etthen338, label %etfinif338
	etthen338:
	%var343 = load i32, i32* @_suma1
	%var345 = add i32 0, 7
	%var344 = add i32 %var343, %var345
	store i32 %var344, i32* @_suma1
	%var347 = load i32, i32* @_aux1
	%var349 = add i32 0, 1
	%var348 = add i32 %var347, %var349
	store i32 %var348, i32* @_aux1
	br label %etfinif338
	etfinif338:
	br label %etfinif322
	etfinif322:
	%var352 = load i32, i32* @_aux1
	%var354 = add i32 0, 3
	%var353 = icmp sle i32  %var352, %var354
	br i1 %var353, label %etthen351, label %etfinif351
	etthen351:
	%var356 = add i32 0, 9
	store i32 %var356, i32* @_temp1
	br label %etwhile358
	etwhile358:
	%var359 = load i32, i32* @_temp1
	%var361 = add i32 0, 1
	%var360 = icmp sgt i32  %var359, %var361
	br i1 %var360, label %etwhiletrue358, label %etfinwhile358
	etwhiletrue358:
	%var363 = load i32, i32* @_temp1
	%var365 = add i32 0, 2
	%var364 = sub i32 %var363, %var365
	store i32 %var364, i32* @_temp1
	br label %etwhile358
	etfinwhile358:
	%var368 = load i32, i32* @_temp1
	%var370 = add i32 0, 1
	%var369 = icmp eq i32  %var368, %var370
	br i1 %var369, label %etthen367, label %etfinif367
	etthen367:
	%var372 = load i32, i32* @_suma1
	%var374 = add i32 0, 9
	%var373 = add i32 %var372, %var374
	store i32 %var373, i32* @_suma1
	%var376 = load i32, i32* @_aux1
	%var378 = add i32 0, 1
	%var377 = add i32 %var376, %var378
	store i32 %var377, i32* @_aux1
	br label %etfinif367
	etfinif367:
	br label %etfinif351
	etfinif351:
	%var381 = load i32, i32* @_aux1
	%var383 = add i32 0, 3
	%var382 = icmp slt i32  %var381, %var383
	br i1 %var382, label %etthen380, label %etfinif380
	etthen380:
	%dest385 = call i32 @puts(i8* getelementptr ([57 x i8], [57 x i8] * @strnull, i32 0, i32 0))
	%var386 = add i32 0, 0
	store i32 %var386, i32* @_suma1
	br label %etfinif380
	etfinif380:
	br label %etfinif286
	etfinif286:
	br label %etfinif279
	etfinif279:
	br label %etfinif272
	etfinif272:
	%var267 = load i32, i32* @_suma1
	%var266 = add i32 %var265, %var267
	store i32 %var266, i32* @_suma2
	%var389 = load i32, i32* @_aux2
	%var391 = add i32 0, 1
	%var390 = add i32 %var389, %var391
	store i32 %var390, i32* @_aux2
	br label %etfinif260
	etfinif260:
	br label %etfinif124
	etfinif124:
	%var394 = load i32, i32* @_aux2
	%var396 = add i32 0, 3
	%var395 = icmp sle i32  %var394, %var396
	br i1 %var395, label %etthen393, label %etfinif393
	etthen393:
	%var398 = add i32 0, 5
	store i32 %var398, i32* @_temp2
	br label %etwhile400
	etwhile400:
	%var401 = load i32, i32* @_temp2
	%var403 = add i32 0, 1
	%var402 = icmp sgt i32  %var401, %var403
	br i1 %var402, label %etwhiletrue400, label %etfinwhile400
	etwhiletrue400:
	%var405 = load i32, i32* @_temp2
	%var407 = add i32 0, 2
	%var406 = sub i32 %var405, %var407
	store i32 %var406, i32* @_temp2
	br label %etwhile400
	etfinwhile400:
	%var410 = load i32, i32* @_temp2
	%var412 = add i32 0, 1
	%var411 = icmp eq i32  %var410, %var412
	br i1 %var411, label %etthen409, label %etfinif409
	etthen409:
	%var414 = load i32, i32* @_suma2
	%var416 = add i32 0, 5
	%var415 = add i32 %var414, %var416
	store i32 %var415, i32* @_suma2
	%var418 = load i32, i32* @_aux2
	%var420 = add i32 0, 1
	%var419 = add i32 %var418, %var420
	store i32 %var419, i32* @_aux2
	br label %etfinif409
	etfinif409:
	br label %etfinif393
	etfinif393:
	%var423 = load i32, i32* @_aux2
	%var425 = add i32 0, 3
	%var424 = icmp slt i32  %var423, %var425
	br i1 %var424, label %etthen422, label %etfinif422
	etthen422:
	%dest427 = call i32 @puts(i8* getelementptr ([57 x i8], [57 x i8] * @str8, i32 0, i32 0))
	%var428 = add i32 0, 0
	store i32 %var428, i32* @_suma2
	br label %etfinif422
	etfinif422:
	br label %etfinif30
	etfinif30:
	br label %etfinif23
	etfinif23:
	br label %etfinif16
	etfinif16:
	%var11 = load i32, i32* @_suma2
	store i32 %var11, i32* @num1
	%var432 = load i32, i32* @num1
	%dest431 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var432)
	
	ret i32 0
}