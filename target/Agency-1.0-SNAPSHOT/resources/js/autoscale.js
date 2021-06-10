window.addEventListener("resize", AutoScale); //Маштабируем страницу при растягивании окна

AutoScale(); //Маштабируем страницу после загрузки

function AutoScale()
{
	let width = window.innerWidth; //Ширина окна
	
	if(width > 1280)
	{
		ChangeScale("big");
	}
	else if(width <= 1280 && width > 720)
	{
		ChangeScale("normal");
	}
	else if(width < 720)
	{
		ChangeScale("small");
	}
}