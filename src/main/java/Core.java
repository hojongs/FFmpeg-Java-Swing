import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class Core
{
	public String FFMPEG_PATH = null;
	private String CONF_FILE;

	public Core(String _CONF_FILE)
	{
		CONF_FILE = _CONF_FILE;
		assert CONF_FILE != null;

		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(CONF_FILE));

			FFMPEG_PATH = (String) jsonObj.get("FFMPEG_PATH");
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void ffmpegEncode(String _FFMPEG_PATH, String input, String output)
	{
		try
		{
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("FFMPEG_PATH", _FFMPEG_PATH.replace("\\", "/"));

			try (PrintWriter writer = new PrintWriter(new FileWriter(CONF_FILE)))
			{
				writer.println(jsonObj.toString());
			}
		}
		catch (Exception e) { e.printStackTrace(); }

		try
		{
			FFmpeg ffmpeg = new FFmpeg(_FFMPEG_PATH + "/ffmpeg");
			FFprobe ffprobe = new FFprobe(_FFMPEG_PATH + "/ffprobe");

			FFmpegBuilder builder = new FFmpegBuilder()
					.setInput(input)
					.addOutput(output)
					.done();

			FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
			executor.createJob(builder).run();
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
