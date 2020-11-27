#include<stdio.h>
int main(){
	int std;
	char name;
	printf("\nEnter number : ");
	scanf("%d",&std);
	for(int i = 1; i <= std; i++){
		printf("\nName [%d] : ",i);
		scanf("%s",&name);
	}
}