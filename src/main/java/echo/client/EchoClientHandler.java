package echo.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private String req;

    public EchoClientHandler(String req){
        this.req = req;
        System.out.println("message is " +req);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client send message : " +req);
        ctx.writeAndFlush(req);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive msg :" +msg);
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Client catch exception "+cause.getMessage());
        ctx.flush();
    }
}
