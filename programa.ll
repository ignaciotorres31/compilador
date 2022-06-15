;Programa: Prueba
source_filename = "Prueba.txt"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.16.27038"

declare i32 @printf(i8*, ...)
declare i32 @puts(i8*)
declare i32 @scanf(i8* %0, ...)

@str.listavacia = private constant [20 x i8] c"La lista esta vacia\00"
@str.pivotpositivo = private constant [22 x i8] c"El valor debe ser >=1\00"
@str.cantinsuficiente = private constant [47 x i8] c"La lista tiene menos elementos que el indicado\00"
@str.cantidadimpares = private constant [57 x i8] c"No existen suficientes elementos impares para el calculo\00"
@.integer = private constant [4 x i8] c"%d\0A\00"
@.float = private constant [5 x i8] c"%lf\0A\00"
@.int_read_format = unnamed_addr constant [3 x i8] c"%d\00"
@.double_read_format = unnamed_addr constant [4 x i8]  c"%lf\00"


@str60 = private constant [20 x i8] c"Resultado primer if\00"
@str84 = private constant [21 x i8] c"Resultado segundo if\00"
@str97 = private constant [22 x i8] c"Resultado primer else\00"
@str113 = private constant [23 x i8] c"Resultado segundo else\00"
@f2 = global double 0.0
@num1 = global i32 0
@a1 = global i32 0
@f1 = global double 0.0
@a2 = global i32 0


define i32 @main(i32, i8**) {
	%var7 = add i32 0, 2
	%var8 = add i32 0, 3
	%var9 = add i32 0, 5
	%var10 = mul i32 %var8, %var9
	%var11 = add i32 %var7, %var10
	%var12 = add i32 0, 2
	%var13 = sub i32 %var11, %var12
	%var14 = add i32 0, 6
	%var15 = add i32 0, 3
	%var16 = sdiv i32 %var14, %var15
	%var17 = add i32 0, 2
	%var18 = mul i32 %var16, %var17
	%var19 = add i32 %var13, %var18
	%var20 = add i32 0, 7
	%var21 = sub i32 %var19, %var20
	store i32 %var21, i32* @a1
	%var24 = load i32, i32* @a1
	%dest25 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var24)
	%var26 = fadd double 0.0, 3.2
	store double %var26, double* @f1
	br label %etwhile136
	etwhile136:
	%var29 = load i32, i32* @a1
	%var30 = add i32 0, 5
	%var32 = icmp sgt i32 %var29, %var30
	%var33 = load i32, i32* @a1
	%var34 = add i32 0, 10
	%var36 = icmp slt i32 %var33, %var34
	%var37 = and i1 %var32, %var36
	br i1 %var37, label %etwhiletrue136, label %etfinwhile136
	etwhiletrue136:
	%var38 = load double, double* @f1
	%var39 = fadd double 0.0, 0.8
	%var40 = fadd double %var38, %var39
	%var41 = add i32 0, 2
	%var42 = sub i32 0, %var41
	%var45 = sitofp i32 %var42 to double
	%var43 = fadd double 0.0, 2.0
	%var44 = fsub double 0.0,%var43
	%var46 = fmul double %var45, %var44
	%var48 = fcmp oeq double %var40, %var46
	br i1 %var48, label %etthen119, label %etelse119
	etthen119:
	%var49 = add i32 0, 6
	%var51 = sitofp i32 %var49 to double
	%var50 = fadd double 0.0, 2.0
	%var52 = fdiv double %var51, %var50
	store double %var52, double* @f2
	%var55 = load double, double* @f1
	%var56 = load double, double* @f2
	%var57 = fadd double %var55, %var56
	store double %var57, double* @f1
	%dest61 = call i32 @puts(i8* getelementptr ([20 x i8], [20 x i8] * @str60, i32 0, i32 0))
	%var62 = load double, double* @f1
	%dest63 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var62)
	%var64 = load double, double* @f1
	%var65 = fadd double 0.0, 4.2
	%var66 = fadd double %var64, %var65
	%var67 = add i32 0, 1
	%var68 = sub i32 0, %var67
	%var71 = sitofp i32 %var68 to double
	%var69 = fadd double 0.0, 2.0
	%var70 = fsub double 0.0,%var69
	%var72 = fmul double %var71, %var70
	%var74 = fcmp oeq double %var66, %var72
	br i1 %var74, label %etthen103, label %etelse103
	etthen103:
	%var75 = add i32 0, 3
	%var76 = sitofp i32 %var75 to double
	store double %var76, double* @f2
	%var79 = load double, double* @f1
	%var80 = load double, double* @f2
	%var81 = fadd double %var79, %var80
	store double %var81, double* @f1
	%dest85 = call i32 @puts(i8* getelementptr ([21 x i8], [21 x i8] * @str84, i32 0, i32 0))
	%var86 = load double, double* @f1
	%dest87 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var86)
	br label %etfinif103
	etelse103:
	%var88 = add i32 0, 15
	%var89 = sitofp i32 %var88 to double
	store double %var89, double* @f2
	%var92 = load double, double* @f2
	%var93 = load double, double* @f1
	%var94 = fsub double %var92, %var93
	store double %var94, double* @f2
	%dest98 = call i32 @puts(i8* getelementptr ([22 x i8], [22 x i8] * @str97, i32 0, i32 0))
	%var99 = load double, double* @f2
	%dest100 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var99)
	br label %etfinif103
	etfinif103:
	br label %etfinif119
	etelse119:
	%var104 = add i32 0, 5
	%var105 = sitofp i32 %var104 to double
	store double %var105, double* @f2
	%var108 = load double, double* @f2
	%var109 = load double, double* @f1
	%var110 = fsub double %var108, %var109
	store double %var110, double* @f2
	%dest114 = call i32 @puts(i8* getelementptr ([23 x i8], [23 x i8] * @str113, i32 0, i32 0))
	%var115 = load double, double* @f2
	%dest116 = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double %var115)
	br label %etfinif119
	etfinif119:
	%var120 = load i32, i32* @a1
	%var121 = add i32 0, 2
	%var122 = add i32 0, 4
	%var123 = mul i32 %var121, %var122
	%var124 = add i32 0, 1
	%var125 = sdiv i32 %var123, %var124
	%var126 = add i32 %var120, %var125
	%var127 = add i32 0, 3
	%var128 = add i32 0, 8
	%var129 = mul i32 %var127, %var128
	%var130 = sub i32 %var126, %var129
	store i32 %var130, i32* @a1
	%var133 = load i32, i32* @a1
	%dest134 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %var133)
	br label %etwhile136
	etfinwhile136:
	
	ret i32 0
}