;Programa: Prueba
source_filename = "Prueba.txt"
target datalayout = "e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-windows-msvc19.16.27038"

declare i32 @printf(i8*, ...)

@.integer = private constant [4 x i8] c"%d\0A\00"

define i32 @main(i32, i8**) {
	@str = private constant [11 x i8] c Hola  "
	%ptro.11 = call i32 @puts(i8* getelementptr ([11 x i8], [11 x i8] * %ptro.10, i32 0, i32 0))
	%ptro.12 = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 null)
	ret i32 0
}


